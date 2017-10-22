package com.tetris.app;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.util.PlayerEmulator;

public class App {
    public static void main(String[] args) throws InterruptedException, FigureInitException {
        System.out.println("Starting game..");
        Container container = new Container();
        PlayerEmulator emulator = new PlayerEmulator();
        while (true) {
            Figure figure = new TFigure(container);
            figure.init(1, 4, SpacePose.FIRST);
            container.addFigure(figure);
            container.represent();
            container.print();

            emulator.accept(figure);

            while (figure.moveForwardPossible()) {
                emulator.doAction();
                System.out.print("\033[H\033[2J");
                figure.moveForward();
                container.represent();
                container.print();
                Thread.sleep(300);
            }
        }
    }
}
