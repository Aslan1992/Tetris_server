package com.tetris.app.figures.impls;

import com.tetris.app.core.Container;
import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;
import com.tetris.app.logic.impls.approvers.ActionApproverForIFigure;
import com.tetris.app.logic.impls.builders.IFigureBuilder;

import java.util.ArrayList;
import java.util.List;

public class IFigure implements Figure {
    private int y;
    private int x;
    private List<Block> blocks;
    private Container container;
    private SpacePose spacePose;
    private ActionApprover actionApprover;
    private FigureBuilder builder;

    public IFigure(Container container) {
        this.container = container;
    }

    @Override
    public void init(int y, int x, SpacePose spacePose) throws FigureInitException {
        this.y = y;
        this.x = x;
        this.spacePose = spacePose;
        blocks = new ArrayList<>();
        actionApprover = new ActionApproverForIFigure(container, this);
        builder = new IFigureBuilder();

        if(actionApprover.putBlocksPossible() && actionApprover.figureInsideOfArea()) {
            blocks = builder.build(y, x, spacePose);
        } else {
            throw new FigureInitException("Cannot init IFigure at y=" + y + ", x=" + x);
        }
    }

    @Override
    public SpacePose getSpacePose() {
        return spacePose;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void removeBlock(int i, int j) {
        blocks.removeIf(block -> block.getY() == i && block.getX() == j);
    }

    @Override
    public void moveForward() {
        if (actionApprover.moveForwardPossible()){
            blocks.forEach(Block::moveForward);
            y++;
        }
    }

    @Override
    public void moveRight() {
        if(actionApprover.moveRightPossible()) {
            blocks.forEach(Block::moveRight);
            x++;
        }
    }

    @Override
    public void moveLeft() {
        if (actionApprover.moveLeftPossible()) {
            blocks.forEach(Block::moveLeft);
            x--;
        }
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

    @Override
    public boolean moveForwardPossible() {
        return actionApprover.moveForwardPossible();
    }
}
