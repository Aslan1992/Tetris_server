package com.tetris.app.core;

import com.tetris.app.figures.Figure;
import com.tetris.app.figures.impls.IFigure;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.util.RandomNumberGenerator;

public class FigureCreator {
    private Container container;

    public FigureCreator(Container container) {
        this.container = container;
    }

    public Figure createAny() {
        int num = RandomNumberGenerator.generate(1, 2);
        if (num == 1) {
            return new IFigure(container);
        } else if (num == 2) {
            return new TFigure(container);
        }
        return null;
    }
}
