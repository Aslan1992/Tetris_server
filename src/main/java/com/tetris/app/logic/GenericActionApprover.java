package com.tetris.app.logic;

import com.tetris.app.presentation.Container;
import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;

public class GenericActionApprover {

    protected Container container;
    protected Figure figure;
    protected int y;
    protected int x;

    public GenericActionApprover(Container container, Figure figure) {
        this.container = container;
        this.figure = figure;
    }

    protected boolean validPoint(int i, int j) {
        if (i >= 0 && i < Container.DIMENSION && j>=0 && j < Container.DIMENSION) {
            Block[][] state = container.getCurrentState();
            return state[i][j] == null;
        }
        return false;
    }
}
