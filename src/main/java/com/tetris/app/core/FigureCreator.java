package com.tetris.app.core;

import com.tetris.app.figures.Figure;
import com.tetris.app.figures.impls.IFigure;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.impls.approvers.ActionApproverForIFigure;
import com.tetris.app.logic.impls.approvers.ActionApproverForTFigure;
import com.tetris.app.logic.impls.builders.IFigureBuilder;
import com.tetris.app.logic.impls.builders.TFigureBuilder;
import com.tetris.app.util.RandomNumberGenerator;

public class FigureCreator {
    private Container container;

    public FigureCreator(Container container) {
        this.container = container;
    }

    public Figure createAny() {
        int num = RandomNumberGenerator.generate(1, 2);
        ActionApprover actionApprover;

        if (num == 1) {
            actionApprover = new ActionApproverForIFigure(container);
            IFigure iFigure = new IFigure(container, actionApprover, new IFigureBuilder());
            actionApprover.setFigure(iFigure);

            return iFigure;

        } else if (num == 2) {
            actionApprover = new ActionApproverForTFigure(container);
            TFigure tFigure = new TFigure(container, actionApprover, new TFigureBuilder());
            actionApprover.setFigure(tFigure);

            return tFigure;

        }
        return null;
    }
}
