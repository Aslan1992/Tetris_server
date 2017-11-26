package com.tetris.app.figures;

import com.tetris.app.core.Container;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFigure {
    protected int y;
    protected int x;
    protected SpacePose spacePose;
    protected List<Block> blocks;
    protected Container container;
    protected ActionApprover actionApprover;
    protected FigureBuilder builder;

    public AbstractFigure(Container container, ActionApprover actionApprover, FigureBuilder builder) {
        this.container = container;
        this.actionApprover = actionApprover;
        this.builder = builder;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public SpacePose getSpacePose() {
        return spacePose;
    }
    public List<Block> getBlocks() {
        return blocks;
    }

    public void init(int y, int x, SpacePose spacePose) throws FigureInitException {
        this.y = y;
        this.x = x;
        this.spacePose = spacePose;
        blocks = new ArrayList<>();
        if (actionApprover.putBlocksPossible() && actionApprover.figureInsideOfArea()) {
            blocks = builder.build(y, x, spacePose);
        } else {
            throw new FigureInitException("Cannot init Figure at y=" + y + ", x=" + x);
        }
    }

    public void moveForward() {
        if (actionApprover.moveForwardPossible()){
            blocks.forEach(Block::moveForward);
            y++;
        }
    }

    public void moveRight() {
        if(actionApprover.moveRightPossible()) {
            blocks.forEach(Block::moveRight);
            x++;
        }
    }

    public void moveLeft() {
        if (actionApprover.moveLeftPossible()) {
            blocks.forEach(Block::moveLeft);
            x--;
        }
    }

    public void removeBlock(int i, int j) {
        blocks.removeIf(block -> block.getY() == i && block.getX() == j);
    }

    public boolean moveForwardPossible() {
        return actionApprover.moveForwardPossible();
    }

    public void turnAround() {
        if (actionApprover.turnAroundPossible()) {
            spacePose = SpacePose.getNext(spacePose);
            blocks = builder.build(y, x, spacePose);
        }
    }
}
