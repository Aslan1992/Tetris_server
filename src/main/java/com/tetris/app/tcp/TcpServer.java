package com.tetris.app.tcp;

import com.tetris.app.util.Encoder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static final int PORT = 8181;

    private InetAddress address;
    private ServerSocket serverSocket;
    private Socket client;
    private DataOutputStream writer = null;
    private Encoder encoder;
    private boolean clientConnected = false;

    public TcpServer() throws IOException {
        address = InetAddress.getByName("localhost");
        serverSocket = new ServerSocket(PORT, 0, address);
    }

    public void start() throws IOException {
        System.out.println("Waiting for client connections..");
        client = serverSocket.accept();
        System.out.println("Client connected..");
        clientConnected = true;
        writer = new DataOutputStream(client.getOutputStream());
        encoder = new Encoder();
    }

    public void send(String[][] array) throws IOException {
        String encodedLine = encoder.encode(array);
        byte[] data = encodedLine.getBytes();
        writer.write(data);
    }

    public boolean isClientConnected() {
        return clientConnected;
    }

    public void sendMessageToClient(String msg) throws IOException {
        writer.write(msg.getBytes());
    }

}
