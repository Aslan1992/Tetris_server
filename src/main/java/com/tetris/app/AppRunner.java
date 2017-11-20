package com.tetris.app;

import com.tetris.app.core.Game;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException, IOException {
        new Game().run();
    }
}
