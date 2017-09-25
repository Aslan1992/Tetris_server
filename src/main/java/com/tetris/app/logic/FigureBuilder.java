package com.tetris.app.logic;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.SpacePose;

import java.util.List;

public interface FigureBuilder {
    List<Block> build(int y, int x, SpacePose pose);
}
