package ua.lviv.navpil.exceptions;

import java.io.IOException;
import java.util.function.Function;

public class ExceptionsTest {

    public static void main(String[] args) {

        ExceptionsTest e = new ExceptionsTest();
//        e.callMethodAsAFunction(rethrowFunction(e::methodWithException));
        try {
            e.noGenericsThrowable();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        throwAsUnchecked(new IOException());


        e.methodWithThrowable();

        try {
            e.callMethodDirectly();
        } catch (Exception e1) {
            System.out.println("Checked exception was caught " + e1);
        }
    }



    public String callMethodDirectly() {
        String retValue;
        try {
            retValue = methodWithException(1);
        } catch (Exception e) {
            throwAsUnchecked(e);
            return null;
        }
        return retValue;
    }

    private static <E extends Throwable> void throwAsUnchecked(Exception exception) throws E { throw (E)exception; }

    public String callMethodAsAFunction(Function<Integer, String> function) {
        String retValue;
        try {
            retValue = function.apply(1);
        } catch (Exception e) {
            throw e;
        }
        return retValue;
    }


    public String methodWithException(Integer i) throws Exception {
        throw new IOException();
    }

    public <E extends Exception> void methodWithThrowable() throws E {
        throw (E)new IOException();
    }

    public void noGenericsThrowable() throws Throwable {
        throw new IOException();
    }
}
