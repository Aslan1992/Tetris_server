package com.tetris.app;

import com.tetris.app.tcp.TcpServer;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.util.PlayerEmulator;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Starting game..");
        Container container = new Container();
        PlayerEmulator emulator = new PlayerEmulator();
        TcpServer server = new TcpServer();
        server.start();
        while (true) {
            if (server.isClientConnected()) {
                Figure figure = new TFigure(container);
                try {
                    figure.init(1, 4, SpacePose.FIRST);
                } catch (FigureInitException e) {
                    //Продумать грамотное завершение игры
                    //Отправлять на клиент сообщение и завершать игру
                    server.sendMessageToClient("game over");
                    System.out.println("Game over because field is fully filled vertically");
                    e.printStackTrace();
                }
                container.addFigure(figure);
                container.represent();
                container.print();

                emulator.accept(figure);

                while (figure.moveForwardPossible()) {
                    emulator.doAction();
                    System.out.print("\033[H\033[2J");
                    figure.moveForward();
                    container.represent();
                    String[][] representation = container.getStateAsStringArray();
                    server.send(representation);
                    Thread.sleep(300);
                }
                //means nothing
                if (1 != 1) break;
            }
        }
    }
}
