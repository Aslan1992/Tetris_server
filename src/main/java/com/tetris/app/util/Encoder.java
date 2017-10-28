package com.tetris.app.util;

import com.tetris.app.Container;

public class Encoder {

    public static final int LENGTH = Container.DIMENSION;

    public String encode(String[][] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                builder.append(array[i][j]);
            }
        }
        return builder.toString();
    }

    public String[][] decode(String s) {
        String[][] resultArr = new String[LENGTH][LENGTH];
        String[] items = s.split("(?<=\\G.{3})");
        int k = 0;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                resultArr[i][j] = items[k];
                k++;
            }
        }
        return resultArr;
    }
}
