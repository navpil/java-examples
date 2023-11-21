package ua.lviv.navpil.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReduceCollect {

    public static void main(String[] args) {
        List<Integer> one2ten = IntStream.range(1, 1000).boxed().collect(Collectors.toList());

        //reduce should be immutable, therefore this example is WRONG (check the results in the end)
        Averager reduce = one2ten.parallelStream().reduce(
                new Averager(),
                (averager, integer) -> {
                    averager.addSum(integer);
                    averager.acc();
                    return averager;
                },
                (averager, averager2) -> {
                    averager.addSum(averager2.getSum());
                    averager.count += averager2.count;
                    return averager;
                }
        );

        //collect is mutable and is mostly for performance reasons
        Averager collect = one2ten.parallelStream().collect(
                Averager::new,
                (averager, integer) -> {
                    averager.addSum(integer);
                    averager.acc();
                },
                (averager, averager2) -> {
                    averager.addSum(averager2.getSum());
                    averager.count += averager2.count;
                }
        );

        //correct immutable reduce
        ImmutableAverager correctReduce = one2ten.parallelStream().reduce(
                new ImmutableAverager(0, 0),
                (averager, integer) -> averager.withAddedValues(integer, 1),
                (averager, averager2) -> averager.withAddedValues(averager2.sum, averager2.count)
        );

        System.out.println(reduce);
        System.out.println(collect);
        System.out.println(correctReduce);
    }

    public static class Averager {
        private int sum;
        private int count;

        public int getSum() {
            return sum;
        }

        public void addSum(int sum) {
            this.sum += sum;
        }

        public void acc() {
            this.count++;
        }

        @Override
        public String toString() {
            return "Averager{" +
                    "sum=" + sum +
                    ", count=" + count +
                    '}';
        }
    }

    public static class ImmutableAverager {
        private final int sum;
        private final int count;

        public ImmutableAverager(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        public ImmutableAverager withAddedValues(int sum, int count) {
            return new ImmutableAverager(this.sum + sum, this.count + count);
        }

        @Override
        public String toString() {
            return "ImmutableAverager{" +
                    "sum=" + sum +
                    ", count=" + count +
                    '}';
        }

    }
}
