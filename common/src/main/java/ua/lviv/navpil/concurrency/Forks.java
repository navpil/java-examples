package ua.lviv.navpil.concurrency;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Forks {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        List<Integer> list = IntStream.range(0, 50).boxed().collect(Collectors.toList());

        FindMax task = new FindMax(list);
        forkJoinPool.invoke(task);
        System.out.println(task.result);
    }

    private static class FindMax extends RecursiveAction {

        private final List<Integer> list;
        private int result;

        public FindMax(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.size() == 1) {
                result = list.get(0);
                return;
            }
            int i = list.size() / 2;
            FindMax t1 = new FindMax(list.subList(0, i));
            FindMax t2 = new FindMax(list.subList(i, list.size()));
            invokeAll(t1, t2);

            result = Math.max(t1.result, t2.result);
        }

        public int getResult() {
            return result;
        }
    }
}
