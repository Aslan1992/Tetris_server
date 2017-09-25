package com.tetris.app.logic;

public interface ActionApprover {
    boolean moveForwardPossible();
    boolean moveLeftPossible();
    boolean moveRightPossible();
    boolean putBlocksPossible();
    boolean figureInsideOfContainer();
    boolean turnAroundPossible();
}
