package ua.lviv.navpil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaZeroServer implements Runnable {

    //Java 0 does not allow initializing final fields in the constructor
    private Socket socket;

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(8099);
        while(true) {
            new Thread(new JavaZeroServer(socket.accept())).start();
        }

    }

    public JavaZeroServer(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            handleConnection(socket);
        } catch (IOException ignore) {
            System.out.println("Could not handle socket");
        }
    }

    private void handleConnection(Socket connection) throws IOException {
        String request = readRequest(connection);
        System.out.println(request);

        String url = getPath(request);

        byte[] responseBytes = createResponse(url);

        connection.getOutputStream().write(responseBytes);
        connection.close();
    }

    private byte[] createResponse(String url) {
        String response = "HTTP/1.0 200 OK\nContent-Type: application/json\n\n{\"URL\": \"" + url + "\"}";

        byte[] responseBytes = new byte[response.length()];
        response.getBytes(0, response.length(), responseBytes, 0);
        return responseBytes;
    }

    private String getPath(String request) {
        int firstSpace = request.indexOf(' ');
        int secondSpace = request.indexOf(' ', firstSpace + 1);
        return request.substring(firstSpace, secondSpace);
    }

    private String readRequest(Socket connection) throws IOException {
        BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        StringBuffer sb = new StringBuffer();
        int size;
        byte[] buffer = new byte[16];
        do {
            size = in.read(buffer);
            sb.append(new String(buffer, 0, 0, size));
        } while (size == 16);
        return sb.toString();
    }
}
