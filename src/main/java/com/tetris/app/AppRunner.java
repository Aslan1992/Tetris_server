package com.tetris.app;

import com.tetris.app.core.Game;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("This server side for game TETRIS (Please, don't ask me why I made like this:)) " +
                "To start game run client application (tetris-client.exe)");
        new Game().run();
    }
}
