package ua.lviv.navpil.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class JmxMain {

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName on = new ObjectName("ua.lviv.navpil.jmx:type=Hello");

        Hello hello = new Hello();

        mbs.registerMBean(hello, on);

        System.out.println("Waiting forever...");

        Thread.sleep(Long.MAX_VALUE);
    }
}
