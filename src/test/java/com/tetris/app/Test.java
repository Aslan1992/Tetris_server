package com.tetris.app;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.util.RandomNumberGenerator;

public class Test {

    @org.junit.Test
    public void test() throws FigureInitException {
        for (int i = 0; i < 10; i++) {
            int num = RandomNumberGenerator.generate(1, 4);
            System.out.println(num);
        }
    }
}
