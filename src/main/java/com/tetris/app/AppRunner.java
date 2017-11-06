package com.tetris.app;

import com.tetris.app.tcp.TcpServer;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Starting game..");
//        new Game().run();
        TcpServer server = new TcpServer();
        server.start();
        if (server.isClientConnected()) {
            int code  = server.receive();
            System.out.println("Code from client: "  + code);
        }
    }
}
