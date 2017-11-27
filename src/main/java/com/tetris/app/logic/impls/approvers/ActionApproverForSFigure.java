package com.tetris.app.logic.impls.approvers;

import com.tetris.app.core.Container;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.GenericActionApprover;

public class ActionApproverForSFigure extends GenericActionApprover implements ActionApprover {

    public ActionApproverForSFigure(Container container) {
        super(container);
    }

    @Override
    public boolean moveForwardPossible() {
        setYX(figure);
        return validPoint(y + 2, x) && validPoint(y + 2, x + 1);
    }

    @Override
    public boolean moveLeftPossible() {
        setYX(figure);
        return validPoint(y, x - 1) && validPoint(y + 1, x - 1);
    }

    @Override
    public boolean moveRightPossible() {
        setYX(figure);
        return validPoint(y, x + 2) && validPoint(y + 1, x + 2);
    }

    @Override
    public boolean putBlocksPossible() {
        setYX(figure);
        return validPoint(y, x) && validPoint(y, x + 1) && validPoint(y + 1, x) && validPoint(y + 1, x + 1);
    }

    @Override
    public boolean figureInsideOfArea() {
        setYX(figure);
        return y >= 0 && y < Container.Y_DIMENSION - 2 && x >= 0 && x < Container.X_DIMENSION - 2;
    }

    @Override
    public boolean turnAroundPossible() {
        //Doesn't need to implement
        return true;
    }
}
