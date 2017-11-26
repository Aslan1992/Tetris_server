package com.tetris.app.logic.impls.approvers;

import com.tetris.app.core.Container;
import com.tetris.app.figures.Figure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.GenericActionApprover;

public class ActionApproverForIFigure extends GenericActionApprover implements ActionApprover {

    public ActionApproverForIFigure(Container container) {
        super(container);
    }

    @Override
    public boolean moveForwardPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y + 4, x);
            case SECOND:
                return validPoint(y + 1, x) && validPoint(y + 1, x + 1) && validPoint(y + 1, x + 2) && validPoint(y + 1, x + 3);
        }
        return false;
    }

    @Override
    public boolean moveLeftPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x - 1) && validPoint(y + 1, x - 1) && validPoint(y + 2, x - 1) && validPoint(y + 3, x - 1);
            case SECOND:
                return validPoint(y, x - 1);
        }
        return false;
    }

    @Override
    public boolean moveRightPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x + 1) && validPoint(y + 1, x + 1) && validPoint(y + 2, x + 1) && validPoint(y + 3, x + 1);
            case SECOND:
                return validPoint(y, x + 4);
        }
        return false;
    }

    @Override
    public boolean putBlocksPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x) && validPoint(y + 1, x) && validPoint(y + 2, x) && validPoint(y + 3, x);
            case SECOND:
                return validPoint(y, x) && validPoint(y, x + 1) && validPoint(y, x + 2) && validPoint(y, x + 3);
        }
        return false;
    }

    @Override
    public boolean figureInsideOfArea() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return y >= 0 && y < Container.DIMENSION - 3 && x >= 0 && x < Container.DIMENSION;
            case SECOND:
                return y >= 0 && y < Container.DIMENSION && x >= 0 && x < Container.DIMENSION - 3;
        }
        return false;
    }

    @Override
    public boolean turnAroundPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x + 1) && validPoint(y, x + 2) && validPoint(y, x + 3) &&
                        validPoint(y + 1, x + 1) && validPoint(y + 1, x + 2) &&
                        validPoint(y + 2, x + 1) && validPoint(y + 2, x + 2) &&
                        validPoint(y + 3, x + 1) && validPoint(y + 3, x + 2);
            case SECOND:
                return validPoint(y + 1, x) && validPoint(y + 1, x + 1) && validPoint(y + 1, x + 2) &&
                        validPoint(y + 2, x) && validPoint(y + 2, x + 1) && validPoint(y + 2, x + 2)&&
                        validPoint(y + 3, x) && validPoint(y + 3, x + 1) && validPoint(y + 3, x + 2);
        }
        return false;
    }

    private void setYX(Figure figure) {
        this.y = figure.getY();
        this.x = figure.getX();
    }
}
