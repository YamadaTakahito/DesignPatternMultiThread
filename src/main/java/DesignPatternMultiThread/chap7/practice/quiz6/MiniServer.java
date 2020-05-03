package DesignPatternMultiThread.chap7.practice.quiz6;

import java.io.IOException;
import java.net.ServerSocket;

public class MiniServer {
    private final int portnumber;

    public MiniServer(int portnumber) {
        this.portnumber = portnumber;
    }

    public void execute() throws IOException {
        var serverSocket = new ServerSocket(this.portnumber);
        System.out.println("Listening on " + serverSocket);
        try {
            while (true) {
                System.out.println("Accepting ...");
                var clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket);
                new Thread(() -> {
                    try {
                        Service.service(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
