package ua.lviv.navpil.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

//https://www.youtube.com/watch?v=e4MT_OguDKg
public class Subramaniam {

    public static class FilterComposer {

        public <T> Function<T, T> compose(Function<T, T> ... funcs) {
            return Stream.of(funcs).reduce(Function.identity(), Function::compose);
        }

    }

    public static class Mailer {
        public Mailer() {

        }

        public Mailer from(String arg) {/*do something*/return this;}
        public Mailer to(String arg) {/*do something*/return this;}
        public Mailer subject(String arg) {/*do something*/return this;}
        public Mailer body(String arg) {/*do something*/return this;}


        public static void send(Consumer<Mailer> block) {
            //It's up to library developer to decide whether this object can be reused or be cached
            Mailer mailer = new Mailer();
            block.accept(mailer);
            //do something with mailer object

        }
    }


    public static void main(String[] args) {
        Mailer.send(mailer -> mailer.from("one").to("two").subject("Test mail").body("Test body"));

        Function<Integer, Integer> compose = new FilterComposer().compose(i -> i * 2, i -> i - 2, i -> i / 3);

        System.out.println(compose.apply(16));
    }
}
