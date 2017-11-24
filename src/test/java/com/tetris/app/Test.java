package com.tetris.app;

import com.tetris.app.core.Container;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;

public class Test {

    @org.junit.Test
    public void test() throws FigureInitException {
        Container container = new Container();
        Figure f1 = new TFigure(container);
        f1.init(8, 1, SpacePose.THIRD);

        Figure f2 = new TFigure(container);
        f2.init(8, 4, SpacePose.THIRD);

        Figure f3 = new TFigure(container);
        f3.init(8, 7, SpacePose.THIRD);

        Figure f4 = new TFigure(container);
        f4.init(7, 9, SpacePose.SECOND);

        container.addFigure(f1);
        container.addFigure(f2);
        container.addFigure(f3);
        container.addFigure(f4);

        container.represent();
        container.print();

        container.removeFullFilledLines();
        container.represent();
        container.print();
    }
}
