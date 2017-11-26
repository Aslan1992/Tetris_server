package com.tetris.app.logic;

import com.tetris.app.figures.Figure;

public interface ActionApprover {
    boolean moveForwardPossible();
    boolean moveLeftPossible();
    boolean moveRightPossible();
    boolean putBlocksPossible();
    boolean figureInsideOfArea();
    boolean turnAroundPossible();
    void setFigure(Figure figure);
}
