package com.tetris.app.figures.impls;

import com.tetris.app.core.Container;
import com.tetris.app.figures.AbstractFigure;
import com.tetris.app.figures.Figure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;

//Implementation of a square figure
public class SFigure extends AbstractFigure implements Figure {
    public SFigure(Container container, ActionApprover actionApprover, FigureBuilder builder) {
        super(container, actionApprover, builder);
    }

    @Override
    public void turnAround() {
        //Doesn't need to turn around the square
    }
}
