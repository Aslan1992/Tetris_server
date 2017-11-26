package com.tetris.app;

import com.tetris.app.core.Container;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.IFigure;

public class IFigureTest {

    @org.junit.Test
    public void test() throws FigureInitException {
        Container container = new Container();

        Figure figure = new IFigure(container);
        container.addFigure(figure);
        figure.init(0,9, SpacePose.FIRST);
        container.represent();
        container.print();

        figure.moveForward();
        container.represent();
        container.print();

        figure.moveLeft();
        container.represent();
        container.print();

        figure.moveLeft();
        container.represent();
        container.print();

        figure.moveRight();
        container.represent();
        container.print();

    }
}
