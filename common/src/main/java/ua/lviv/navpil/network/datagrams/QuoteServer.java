package ua.lviv.navpil.network.datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuoteServer implements Runnable {

    private final List<String> quotes;
    private final DatagramSocket socket;

    public static void main(String[] args) throws SocketException {
        new Thread(new QuoteServer()).start();
    }

    public QuoteServer() throws SocketException {
        socket = new DatagramSocket(60001);
        quotes = IntStream.range(0, 10).mapToObj(i -> "Quote #" + i).collect(Collectors.toList());
    }

    public void run() {
        quotes.forEach(this::doWithQuote);
    }

    private void doWithQuote(String quote) {
        try {
            byte[] buf = new byte[256];

            // receive request
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            buf = quote.getBytes();

            // send the response to the client at "address" and "port"
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            DatagramPacket responsePacket = new DatagramPacket(buf, buf.length, address, port);
            socket.send(responsePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
