package com.tetris.app.figures;

import com.tetris.app.exceptions.FigureInitException;

import java.util.List;

public interface Figure {
    void init(int y, int x, SpacePose spacePose) throws FigureInitException;
    SpacePose getSpacePose();
    List<Block> getBlocks();
    int getY();
    int getX();
    void removeBlock(int y, int x);
    void moveForward();
    void moveRight();
    void moveLeft();
    void turnAround();
    boolean moveForwardPossible();
}
