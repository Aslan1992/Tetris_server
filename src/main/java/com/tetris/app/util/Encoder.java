package com.tetris.app.util;

import com.tetris.app.core.Container;

public class Encoder {

    public String encode(String[][] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Container.Y_DIMENSION; i++) {
            for (int j = 0; j < Container.X_DIMENSION; j++) {
                builder.append(array[i][j]);
            }
        }
        return builder.toString();
    }

    public String[][] decode(String s) {
        String[][] resultArr = new String[Container.Y_DIMENSION][Container.X_DIMENSION];
        String[] items = s.split("(?<=\\G.{3})");
        int k = 0;
        for (int i = 0; i < Container.Y_DIMENSION; i++) {
            for (int j = 0; j < Container.X_DIMENSION; j++) {
                resultArr[i][j] = items[k];
                k++;
            }
        }
        return resultArr;
    }
}
