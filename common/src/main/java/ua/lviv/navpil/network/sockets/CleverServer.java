package ua.lviv.navpil.network.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CleverServer {
    public static void main(String[] args) throws IOException {

        int portNumber = 60000;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
        ) {
            while (true) {
                new Thread(new CleverServerTask(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }


    public static class CleverServerTask implements Runnable {


        private final Socket clientSocket;

        public CleverServerTask(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                HelloProtocol helloProtocol = new HelloProtocol();
                String inputLine;
                while (!helloProtocol.shouldClose() && (inputLine = in.readLine()) != null) {
                    out.println(helloProtocol.process(inputLine));
                }
            } catch (IOException e) {
                System.err.println("Error caught");
                System.out.println(e.getMessage());
            }
        }
    }

    public static class HelloProtocol {
        private boolean shouldContinue = true;
        private String name = "undefined";

        public String process(String inputLine) {
            String output;
            String[] split = inputLine.split(" ");
            switch (split[0]) {
                case "quit":
                    shouldContinue = false;
                    output = "Quitting";
                    break;
                case "say-hello":
                    output = "Hello " + name;
                    break;
                case "name":
                    output = "Name remembered";
                    name = split[1];
                    break;
                default:
                    output = "Unknown command";
            }
            return output;
        }

        public boolean shouldClose() {
            return !shouldContinue;
        }

    }

};