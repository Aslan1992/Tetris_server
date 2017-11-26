package com.tetris.app.figures.impls;

import com.tetris.app.core.Container;
import com.tetris.app.figures.AbstractFigure;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;

//Implementation of a figure which has a shape of stick (straight vertical line)
public class IFigure extends AbstractFigure implements Figure {

    public IFigure(Container container, ActionApprover actionApprover, FigureBuilder builder) {
        super(container, actionApprover, builder);
    }

    @Override
    public void turnAround() {
        if (actionApprover.turnAroundPossible()) {
            if (spacePose == SpacePose.FIRST) {
                spacePose = SpacePose.SECOND;
            } else if (spacePose == SpacePose.SECOND) {
                spacePose = SpacePose.FIRST;
            }
            blocks = builder.build(y, x, spacePose);
        } else {
            System.out.println("Could not turn around IFigure");
        }
    }
}
