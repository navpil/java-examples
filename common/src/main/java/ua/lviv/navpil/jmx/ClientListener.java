package ua.lviv.navpil.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ClientListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
            echo("\nReceived notification:");
            echo("\tClassName: " + notification.getClass().getName());
            echo("\tSource: " + notification.getSource());
            echo("\tType: " + notification.getType());
            echo("\tMessage: " + notification.getMessage());
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification acn =
                        (AttributeChangeNotification) notification;
                echo("\tAttributeName: " + acn.getAttributeName());
                echo("\tAttributeType: " + acn.getAttributeType());
                echo("\tNewValue: " + acn.getNewValue());
                echo("\tOldValue: " + acn.getOldValue());
            }
    }

    private static void echo(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");

        JMXConnector jmxc = JMXConnectorFactory.connect(jmxServiceURL);

        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        echo("\nDomains:");
        String domains[] = mbsc.getDomains();
        Arrays.sort(domains);
        for (String domain : domains) {
            echo("\tDomain = " + domain);
        }



        echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());

        echo("\nMBean count = " +  mbsc.getMBeanCount());
        echo("\nQuery MBeanServer MBeans:");
        Set<ObjectName> names =
                new TreeSet<ObjectName>(mbsc.queryNames(null, null));
        for (ObjectName name : names) {
            echo("\tObjectName = " + name);
        }

    }
}
