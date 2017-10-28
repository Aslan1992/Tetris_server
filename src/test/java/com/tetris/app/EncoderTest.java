package com.tetris.app;

import com.tetris.app.util.Encoder;
import org.junit.Test;

public class EncoderTest {

    @Test
    public void t() {

        String[][] a = new String[10][10];
        Encoder encoder = new Encoder();

        fillRandom(a);
        print(a);

        String line = encoder.encode(a);

        System.out.println("-------Encoded array----------");
        System.out.println(line);

        String[][] arr = encoder.decode(line);
        print(arr);
    }

    private void print(String[][] a) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    private void fillRandom(String[][] a) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int n = 1 + (int) (Math.random() * 2);
                if(n == 1) {
                    a[i][j] = "[*]";
                } else {
                    a[i][j] = "[ ]";
                }
            }
        }
    }
}
