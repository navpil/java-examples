package ua.lviv.navpil.network.datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MulticastServer implements Runnable {

    private final List<String> quotes;
    private final DatagramSocket socket;

    public static void main(String[] args) throws SocketException {
        new Thread(new MulticastServer()).start();
    }

    public MulticastServer() throws SocketException {
        socket = new DatagramSocket(4445);
        quotes = IntStream.range(0, 10).mapToObj(i -> "Quote #" + i).collect(Collectors.toList());
    }

    public void run() {
        quotes.forEach(this::doWithQuote);
    }

    private void doWithQuote(String quote) {
        try {
            byte[] buf = quote.getBytes();

            InetAddress group = InetAddress.getByName("230.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}