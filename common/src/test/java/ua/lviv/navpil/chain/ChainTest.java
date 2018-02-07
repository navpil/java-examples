package ua.lviv.navpil.chain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ChainTest {
    @Test
    public void testWithReturn() throws Exception {
        Assert.assertEquals(1, Chain.from(ChainTest::toSt)
                        .withReturn(ChainTest::toWrapper)
                        .withReturn(ChainTest::toList)
                        .execute(5).size());
    }

    @Test
    public void testWithReturnCalculation() throws Exception {
        Assert.assertEquals(Integer.valueOf(100),
                Chain.from((Integer i)  -> i * 2).withReturn(integer -> integer * 10)
                        .execute(5));
    }

    @Test
    public void testWithCallback1() throws Exception {

        System.out.println(
                Chain.from(ChainTest::toStWithCallback1)
                .execute(5, StringWrapper::new)
        );

    }

    @Test
    public void testWithCallback2() throws Exception {

        System.out.println(
                Chain.from(ChainTest::toStWithCallback1)
                .withCallback(StringWrapper::new)
                .execute(5)
        );

    }

    public static String toSt(Integer i) {
        return "This is " + i;
    }

    public static StringWrapper toStWithCallback1(Integer i, Function<String, StringWrapper> callback) {
        String t = "This is " + i;
        return callback.apply(t);
    }

    public static StringWrapper toStWithCallback3(Integer i, Function<String, StringWrapper> callback) {
        String t = "This is " + i;
        return callback.apply(t);
    }

    public static void toStWithCallback2(Integer i, Consumer<String> callback) {
        callback.accept("This is " + i);
    }

    public static StringWrapper toWrapper(String w) {
        return new StringWrapper(w);
    }

    public static List<StringWrapper> toList(StringWrapper sw) {
        return Collections.singletonList(sw);
    }

    public static class StringWrapper {

        private final String wrapped;

        public StringWrapper(String wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public String toString() {
            return "StringWrapper{" +
                    "wrapped='" + wrapped + '\'' +
                    '}';
        }
    }


}