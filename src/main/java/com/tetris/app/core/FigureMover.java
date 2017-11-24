package com.tetris.app.core;

import com.tetris.app.figures.Figure;
import com.tetris.app.tcp.TcpServer;

// Класс отвечающий за манипулицию фигурой
// Принимает команды клиента в виде чисел от 1 - 4 (каждое число обозначает команду)
public class FigureMover implements Runnable {
    private TcpServer server;
    private Container container;
    private Figure figure;
    private int scores;

    public FigureMover(TcpServer server, Container container) {
        this.server = server;
        this.container = container;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public void run() {
        while (true) {
            int commandCode;
            try {
                commandCode = server.receive();
                if (commandCode != 0) {
                    move(commandCode);
                    container.represent();
                    server.send(container.getStateAsStringArray(), String.valueOf(scores));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
           //Чтобы избавиться от навящевых подсказок ИДЕИ о бесконечности цикла (потом уберу)
            if (1 != 1) break;
        }
    }

    private void move(int commandCode) {
        switch (commandCode) {
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
