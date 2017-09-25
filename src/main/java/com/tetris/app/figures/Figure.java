package com.tetris.app.figures;

import java.util.List;

public interface Figure {

    List<Block> getBlocks();

    SpacePose getSpacePose();
    int getY();
    int getX();
    void init(int y, int x, SpacePose spacePose);
    void moveForward();
    void moveRight();
    void moveLeft();

    void turnAround();

}
