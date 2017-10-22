package com.tetris.app.figures.impls;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;

import java.util.Collections;
import java.util.List;

// Figure for testing
public class BlockFigure implements Figure {
    private List<Block> blocks;

    @Override
    public SpacePose getSpacePose() {
        return null;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public void init(int y, int x, SpacePose spacePose) {
        blocks = Collections.singletonList(new Block(y, x));
    }

    @Override
    public void moveForward() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void turnAround() {

    }

    @Override
    public boolean moveForwardPossible() {
        return false;
    }
}
