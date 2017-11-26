package com.tetris.app.logic.impls.builders;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.logic.FigureBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TFigureBuilder implements FigureBuilder {

    @Override
    public List<Block> build(int y, int x, SpacePose pose) {
        switch (pose) {
            case FIRST:
                return new ArrayList<>(Arrays.asList(
                        new Block(y, x), new Block(y - 1, x), new Block(y, x - 1), new Block(y, x + 1)));
            case SECOND:
                return new ArrayList<>(Arrays.asList(
                        new Block(y, x), new Block(y - 1, x), new Block(y + 1, x), new Block(y, x - 1)));
            case THIRD:
                return new ArrayList<>(Arrays.asList(
                        new Block(y, x), new Block(y, x + 1), new Block(y, x - 1), new Block(y + 1, x)));
            case FOURTH:
                return new ArrayList<>(Arrays.asList(
                        new Block(y, x), new Block(y, x + 1), new Block(y - 1, x), new Block(y + 1, x)));
        }
        return new ArrayList<>();
    }
}
