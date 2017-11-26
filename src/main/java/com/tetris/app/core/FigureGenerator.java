package com.tetris.app.core;

import com.tetris.app.figures.Figure;
import com.tetris.app.figures.impls.IFigure;
import com.tetris.app.figures.impls.LFigure;
import com.tetris.app.figures.impls.SFigure;
import com.tetris.app.figures.impls.TFigure;
import com.tetris.app.logic.ActionApprover;
import com.tetris.app.logic.impls.approvers.ActionApproverForIFigure;
import com.tetris.app.logic.impls.approvers.ActionApproverForLFigure;
import com.tetris.app.logic.impls.approvers.ActionApproverForSFigure;
import com.tetris.app.logic.impls.approvers.ActionApproverForTFigure;
import com.tetris.app.logic.impls.builders.IFigureBuilder;
import com.tetris.app.logic.impls.builders.LFigureBuilder;
import com.tetris.app.logic.impls.builders.SFigureBuilder;
import com.tetris.app.logic.impls.builders.TFigureBuilder;
import com.tetris.app.util.RandomNumberGenerator;

public class FigureGenerator {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private Container container;

    public FigureGenerator(Container container) {
        this.container = container;
    }

    public Figure getRandomFigure() {
        int num = RandomNumberGenerator.generate(ONE, FOUR);
        ActionApprover actionApprover;

        if (num == ONE) {
            actionApprover = new ActionApproverForIFigure(container);
            IFigure iFigure = new IFigure(container, actionApprover, new IFigureBuilder());
            actionApprover.setFigure(iFigure);
            return iFigure;

        } else if (num == TWO) {
            actionApprover = new ActionApproverForTFigure(container);
            TFigure tFigure = new TFigure(container, actionApprover, new TFigureBuilder());
            actionApprover.setFigure(tFigure);
            return tFigure;

        } else if (num == THREE) {
            actionApprover = new ActionApproverForSFigure(container);
            SFigure sFigure = new SFigure(container, actionApprover, new SFigureBuilder());
            actionApprover.setFigure(sFigure);
            return sFigure;

        } else if (num == FOUR) {
            actionApprover = new ActionApproverForLFigure(container);
            LFigure lFigure = new LFigure(container, actionApprover, new LFigureBuilder());
            actionApprover.setFigure(lFigure);
            return lFigure;
        }
        return null;
    }
}
