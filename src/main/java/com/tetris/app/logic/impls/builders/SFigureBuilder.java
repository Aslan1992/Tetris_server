package com.tetris.app.logic.impls.builders;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.logic.FigureBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SFigureBuilder implements FigureBuilder {
    @Override
    public List<Block> build(int y, int x, SpacePose pose) {
        return new ArrayList<>(Arrays.asList(new Block(y, x), new Block(y, x + 1), new Block(y + 1, x), new Block(y + 1, x + 1)));
    }
}
