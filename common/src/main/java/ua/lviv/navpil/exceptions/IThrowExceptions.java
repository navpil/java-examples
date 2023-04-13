package ua.lviv.navpil.exceptions;

public interface IThrowExceptions {

    //Checked exceptions might not be thrown
    void doWithException() throws MyException;

    //RuntimeExceptions are ignored
    void doWithNoExceptions() throws IllegalArgumentException;

    class MyException extends Exception {
    }

}
