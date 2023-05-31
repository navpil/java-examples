package ua.lviv.navpil.jshell;

import jdk.jshell.JShell;
import jdk.jshell.VarSnippet;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JShellExample {

    public static void main(String[] args) {
        JShell build = JShell.builder().build();
        build.eval("var i = 3;");

        Stream<VarSnippet> variables = build.variables();
        System.out.println(variables.collect(Collectors.toList()));
    }
}
