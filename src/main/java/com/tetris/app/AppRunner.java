package com.tetris.app;

import com.tetris.app.core.Game;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("This server side for game TETRIS. To start game run client application");
        new Game().run();
    }
}
