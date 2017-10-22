package com.tetris.app.util;

public class RandomNumberGenerator {
    public static int generate(int min, int max) {
        return min + (int) (Math.random() * max);
    }
}
