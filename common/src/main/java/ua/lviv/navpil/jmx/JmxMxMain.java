package ua.lviv.navpil.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.LinkedList;

public class JmxMxMain {

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName on = new ObjectName("ua.lviv.navpil.jmx:type=QueueSampler");

        QueueSampler qs = new QueueSampler(new LinkedList<>());

        mbs.registerMBean(qs, on);

        System.out.println("Waiting forever...");

        Thread.sleep(Long.MAX_VALUE);
    }
}
