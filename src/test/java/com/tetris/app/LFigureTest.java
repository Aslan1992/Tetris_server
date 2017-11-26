package com.tetris.app;

import com.tetris.app.core.Container;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.LFigure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.impls.approvers.ActionApproverForLFigure;
import com.tetris.app.logic.impls.builders.LFigureBuilder;

public class LFigureTest {

    @org.junit.Test
    public void test() throws FigureInitException {
        Container container = new Container();

        ActionApprover actionApprover = new ActionApproverForLFigure(container);
        Figure figure = new LFigure(container, actionApprover, new LFigureBuilder());
        actionApprover.setFigure(figure);
        container.addFigure(figure);
        figure.init(7,2, SpacePose.FIRST);
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

        figure.moveLeft();
        container.represent();
        container.print();

        figure.moveLeft();
        container.represent();
        container.print();

    }
}
