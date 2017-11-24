package com.tetris.app.tcp;

import com.tetris.app.util.Encoder;

import java.io.DataInputStream;
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
    private DataInputStream reader = null;
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
        reader = new DataInputStream(client.getInputStream());
        encoder = new Encoder();
    }

    public void send(String[][] array, String scores) throws IOException {
        String encodedLine = encoder.encode(array);
        encodedLine = encodedLine.concat("Total scores: ").concat(scores);
        byte[] data = encodedLine.getBytes();
        writer.write(data);
    }

    public void sendStatusCode(String code) throws IOException {
        byte[] bytes = code.getBytes();
        writer.write(bytes);
    }

    public boolean isClientConnected() {
        return clientConnected;
    }

    public int receive() throws IOException {
        byte[] buffer = new byte[1];
        if (reader.available() > 0) {
            int bytes = reader.read(buffer);
            if (bytes > 0) {
                String code = new String(buffer);
                return Integer.parseInt(code);
            }
        }
        return 0;
    }

    public void closeConnection() throws IOException {
        client.close();
        serverSocket.close();
    }
}
