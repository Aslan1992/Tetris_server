package com.tetris.app.logic;

import com.tetris.app.figures.Figure;

public class Player {

    private Figure figure;

    public void accept(Figure figure) {
        this.figure = figure;
    }

    public void doAction(int code) {
        switch (code) {
            case 0:
            case 1:
                figure.moveForward();
                break;
            case 2:
                figure.moveLeft();
                break;
            case 3:
                figure.moveRight();
                break;
            case 4:
                figure.turnAround();
                break;
        }
    }
}
