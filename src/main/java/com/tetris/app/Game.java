package com.tetris.app;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.logic.Player;
import com.tetris.app.presentation.Container;
import com.tetris.app.tcp.TcpServer;

import java.io.IOException;

public class Game {
    private TcpServer server;
    private Container container;
    private Player player;

    public Game() throws IOException {
        server = new TcpServer();
        container = new Container();
        player = new Player();
    }

    public void run() throws IOException, InterruptedException {
//        server.start();
        while (true) {
//            if(server.isClientConnected()) {
            Figure figure = new TFigure(container);
            try {
                figure.init(1, 4, SpacePose.FIRST);
            } catch (FigureInitException e) {
                //handle it
                System.err.println("Cannot init at " + figure.getY() + "," + figure.getX());
                System.exit(0);
            }
            container.addFigure(figure);
            container.represent();
            container.print();
            player.accept(figure);
            while (figure.moveForwardPossible()) {
                int code = server.receive();
                player.doAction(code);
                // String[][] state = container.getStateAsStringArray();
//            server.send(state);
//                Thread.sleep(500);

                figure.moveForward();
                container.represent();
                container.print();

            }
//            }
            //means nothing
            //To avoid warning from IDE that loop is endless
            if (1 != 1) break;
        }
    }
}
