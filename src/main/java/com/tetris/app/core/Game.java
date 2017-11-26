package com.tetris.app.core;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.tcp.TcpServer;

import java.io.IOException;

public class Game {
    private static final String GAME_OVER_CODE = "666";
    private TcpServer server;
    private Container container;
    private FigureMover figureMover;
    private FigureGenerator generator;
    private int scores;

    public void run() throws IOException, InterruptedException {

        server = new TcpServer();
        container = new Container();
        generator = new FigureGenerator(container);
        figureMover = new FigureMover(server, container);

        server.start();
        while (true) {
            if (server.isClientConnected()) {
                int removed = container.removeFullFilledLines();
                //scores for horizontal lines
                scores += removed * 100;
                Figure figure = generator.getRandomFigure();
                try {
                    //Инициализирую фигуру где-то по середине полотна
                    figure.init(1, 4, SpacePose.FIRST);
                } catch (FigureInitException e) {
                    //Здесь надо сделать так, чтобы игру можно было возобновить, если игрок захочет продолжить
                    System.err.println("Impossible to initialize figure at " + figure.getY() + "," + figure.getX());
                    server.sendStatusCode(GAME_OVER_CODE);
                    server.closeConnection();
                    break;
                }
                container.addFigure(figure);
                container.represent();

                figureMover.setFigure(figure);
                figureMover.setScores(scores);
                //Параллельный поток чтобы реагировать на команды игрока и мгновенно двигать фигуру на клиенте (без заддержек)
                new Thread(figureMover).start();
                while (figure.moveForwardPossible()) {
                    figure.moveForward();
                    container.represent();
                    server.send(container.getStateAsStringArray(), String.valueOf(scores));
                    Thread.sleep(850);
                }
            }
            //To avoid warning from IDE that loop is endless
            if (1 == 2) break;
        }
        run();
    }
}
