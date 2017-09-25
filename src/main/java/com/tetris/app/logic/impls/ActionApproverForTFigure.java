package com.tetris.app.logic.impls;

import com.tetris.app.Container;
import com.tetris.app.figures.Figure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.GenericActionApprover;

public class ActionApproverForTFigure extends GenericActionApprover implements ActionApprover {

    public ActionApproverForTFigure(Container container, Figure figure) {
        super(container, figure);
    }

    @Override
    public boolean moveForwardPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y + 1, x) && validPoint(y + 1, x - 1) && validPoint(y + 1, x + 1);
            case SECOND:
                return validPoint(y + 2, x) && validPoint(y + 1, x - 1);
            case THIRD:
                return validPoint(y + 2, x) && validPoint(y + 1, x - 1) && validPoint(y + 1, x + 1);
            case FOURTH:
                return validPoint(y + 2, x) && validPoint(y + 1, x + 1);
        }
        return false;
    }

    @Override
    public boolean moveLeftPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x - 2) && validPoint(y - 1, x - 1);
            case SECOND:
                return validPoint(y - 1, x - 1) && validPoint(y, x - 2) && validPoint(y + 1, x - 1);
            case THIRD:
                return validPoint(y, x - 2) && validPoint(y + 1, x - 1);
            case FOURTH:
                return validPoint(y - 1, x - 1) && validPoint(y, x - 1) && validPoint(y + 1, x - 1);
        }
        return false;
    }

    @Override
    public boolean moveRightPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x + 2) && validPoint(y - 1, x + 1);
            case SECOND:
                return validPoint(y - 1, x + 1) && validPoint(y, x + 1) && validPoint(y + 1, x + 1);
            case THIRD:
                return validPoint(y, x + 2) && validPoint(y + 1, x + 1);
            case FOURTH:
                return validPoint(y - 1, x + 1) && validPoint(y, x + 2) && validPoint(y + 1, x + 1);
        }
        return false;
    }

    @Override
    public boolean putBlocksPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y, x) && validPoint(y - 1, x) && validPoint(y, x - 1) && validPoint(y, x + 1);
            case SECOND:
                return validPoint(y, x) && validPoint(y, x - 1) && validPoint(y - 1, x) && validPoint(y + 1, x);
            case THIRD:
                return validPoint(y, x) && validPoint(y + 1, x) && validPoint(y, x - 1) && validPoint(y, x + 1);
            case FOURTH:
                return validPoint(y, x) && validPoint(y - 1, x) && validPoint(y + 1, x) && validPoint(y, x + 1);
        }
        return false;
    }

    @Override
    public boolean figureInsideOfContainer() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return y > 0 && y < Container.DIMENSION && x > 0 && x < Container.DIMENSION - 1;
            case SECOND:
                return y > 0 && y < Container.DIMENSION - 1 && x > 0 && x < Container.DIMENSION;
            case THIRD:
                return y >= 0 && y < Container.DIMENSION - 1 && x > 0 && x < Container.DIMENSION - 1;
            case FOURTH:
                return y > 0 && y < Container.DIMENSION - 1 && x >= 0 && x < Container.DIMENSION - 1;
        }
        return false;
    }

    @Override
    public boolean turnAroundPossible() {
        setYX(figure);
        switch (figure.getSpacePose()) {
            case FIRST:
                return validPoint(y + 1, x) && validPoint(y - 1, x + 1) && validPoint(y + 1, x - 1) && validPoint(y - 1, x - 1);
            case SECOND:
                return validPoint(y - 1, x - 1) && validPoint(y + 1, x - 1) && validPoint(y + 1, x + 1) && validPoint(y, x + 1);
            case THIRD:
                return validPoint(y + 1, x - 1) && validPoint(y + 1, x + 1) && validPoint(y - 1, x + 1) && validPoint(y - 1, x);
            case FOURTH:
                return validPoint(y - 1, x - 1) && validPoint(y, x - 1) && validPoint(y + 1, x + 1)  && validPoint(y - 1, x + 1);
        }
        return false;
    }

    private void setYX(Figure figure) {
        this.y = figure.getY();
        this.x = figure.getX();
    }
}
