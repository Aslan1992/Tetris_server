package com.tetris.app.core;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.tcp.TcpServer;

import java.io.IOException;

public class Game {
    private TcpServer server;
    private Container container;
    private FigureMover figureMover;
    private int scores;

    public Game() throws IOException {
        server = new TcpServer();
        container = new Container();
        figureMover = new FigureMover(server, container);
    }

    public void run() throws IOException, InterruptedException {
        server.start();
        while (true) {
            if (server.isClientConnected()) {
                int removed = container.removeFullFilledLines();
                //очки за горизонтальную линии
                scores += removed * 100;

                Figure figure = new TFigure(container);
                try {
                    figure.init(1, 4, SpacePose.FIRST);
                } catch (FigureInitException e) {
                    //Здесь надо сделать так, чтобы игру можно было возобновить, если игрок захочет продолжить
                    System.err.println("Cannot init at " + figure.getY() + "," + figure.getX());
                    System.exit(0);
                }
                container.addFigure(figure);
                container.represent();

                figureMover.setFigure(figure);
                figureMover.setScores(scores);
                //Параллельный поток чтобы реагировать на комманды игрока и мгновенно двигать фигуру на клиенте (без заддержек)
                new Thread(figureMover).start();

                while (figure.moveForwardPossible()) {
                    figure.moveForward();
                    container.represent();
                    server.send(container.getStateAsStringArray(), String.valueOf(scores));
                    Thread.sleep(850);
                }
            }
            //means nothing
            //To avoid warning from IDE that loop is endless
            if (1 != 1) break;
        }
    }
}
