package com.tetris.app.figures.impls;

import com.tetris.app.Container;
import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.FigureBuilder;
import com.tetris.app.logic.impls.ActionApproverForTFigure;
import com.tetris.app.logic.impls.TFigureBuilder;

import java.util.ArrayList;
import java.util.List;

public class TFigure implements Figure {

    private List<Block> blocks;
    private Container container;
    private int y;
    private int x;
    private SpacePose spacePose;
    private ActionApprover actionApprover;
    private FigureBuilder figureBuilder;

    public TFigure(Container container) {
        this.container = container;
    }

    @Override
    public void init(int y, int x, SpacePose spacePose) {
        this.y = y;
        this.x = x;
        this.spacePose = spacePose;
        blocks = new ArrayList<>();
        actionApprover = new ActionApproverForTFigure(container, this);
        figureBuilder = new TFigureBuilder();

        if (actionApprover.putBlocksPossible() && actionApprover.figureInsideOfContainer()) {
            blocks = figureBuilder.build(y, x, spacePose);
        }
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
            spacePose = SpacePose.getNext(spacePose);
            blocks = figureBuilder.build(y, x, spacePose);
        }
    }

    @Override
    public SpacePose getSpacePose() {
        return spacePose;
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
    public List<Block> getBlocks() {
        return blocks;
    }

}
