package ua.lviv.navpil.collections;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Collects {
    public static void main(String[] args) {
        Result collect = IntStream.range(0, 50).boxed().collect(new SumCollector());
        System.out.println(collect.result);
    }

    private static class Result {
        private final int result;

        private Result(int result) {
            this.result = result;
        }
    }

    private static class Summer {

        private int sum;

        public Summer() {
        }

        public Summer(int sum) {
            this.sum = sum;
        }

        public void accept(int i) {
            sum += i;
        }

        public void combine(Summer other) {
            System.out.println("Yah");
            sum += other.sum;
//            return this;
        }

    }

    private static class SumCollector implements Collector<Integer, Summer, Result> {

        @Override
        public Supplier<Summer> supplier() {
            return Summer::new;
        }

        @Override
        public BiConsumer<Summer, Integer> accumulator() {
            return Summer::accept;
        }

        @Override
        public BinaryOperator<Summer> combiner() {
            return (s1, s2) -> new Summer(s1.sum + s2.sum);
        }

        @Override
        public Function<Summer, Result> finisher() {
            return summer -> new Result(summer.sum);
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }
}
