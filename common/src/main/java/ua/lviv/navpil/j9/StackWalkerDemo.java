package ua.lviv.navpil.j9;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerDemo {

    public static void main(String[] args) {
        List<StackWalker.StackFrame> walk = getStackFrames();
        walk.stream().map(StackWalker.StackFrame::getLineNumber).forEach(System.out::println);

        System.out.println(walk);

        try {
            throwException();
        } catch (IOException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
        }
    }

    private static void throwException() throws IOException {
        throw new IOException();
    }

    private static List<StackWalker.StackFrame> getStackFrames() {
        return StackWalker.getInstance().walk(stackFrameStream -> stackFrameStream.collect(Collectors.toList()));
    }


}
