package ua.lviv.navpil.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;

public class NetworkTest {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getLocalHost();
        displayAddress(address);
        System.out.println();
        Collections
                .list(NetworkInterface.getNetworkInterfaces())
                .stream()
                .map(NetworkInterface::getInetAddresses)
                .map(Collections::list)
                .flatMap(Collection::stream)
                .forEach(NetworkTest::displayAddress);
    }

    private static void displayAddress(InetAddress address) {
        String hostName = address.getHostName();
        System.out.println("Hostname: " + hostName);
        System.out.println("Ip: " + address.getHostAddress());
    }
}
