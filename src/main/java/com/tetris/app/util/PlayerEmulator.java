package com.tetris.app.util;


import com.tetris.app.figures.Figure;

public class PlayerEmulator {

    private Figure figure;
    public void accept(Figure figure) {
        this.figure = figure;
    }


    public void doAction() {
        int action;
        action = RandomNumberGenerator.generate(1, 4);
            switch (action) {
                case 1:
                    figure.moveRight();
                    break;
                case 2:
                    figure.moveLeft();
                    break;
                case 3:
                    figure.turnAround();
                    break;
                case 4:
                    figure.moveForward();
            }
            try {
                Thread.sleep(150 * action);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}


