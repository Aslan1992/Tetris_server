package com.tetris.app.figures.impls;

import com.tetris.app.core.Container;
import com.tetris.app.figures.AbstractFigure;
import com.tetris.app.figures.Figure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;

//Implementation of a figure which looks like letter L
public class LFigure extends AbstractFigure implements Figure {
    public LFigure(Container container, ActionApprover actionApprover, FigureBuilder builder) {
        super(container, actionApprover, builder);
    }
}
