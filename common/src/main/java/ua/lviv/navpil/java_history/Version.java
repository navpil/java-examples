package ua.lviv.navpil.java_history;

import java.lang.management.ManagementFactory;

public class Version {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(ManagementFactory.getRuntimeMXBean().getVmVersion());
        System.out.println(ManagementFactory.getRuntimeMXBean().getSpecVersion());

    }
}
