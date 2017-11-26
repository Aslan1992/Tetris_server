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

public class FigureGenerator {
    private Container container;

    public FigureGenerator(Container container) {
        this.container = container;
    }

    public Figure getRandomFigure() {
        int num = 4;
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

        } else if (num == 3) {
            actionApprover = new ActionApproverForSFigure(container);
            SFigure sFigure = new SFigure(container, actionApprover, new SFigureBuilder());
            actionApprover.setFigure(sFigure);

            return sFigure;
        } else if (num == 4) {
            actionApprover = new ActionApproverForLFigure(container);
            LFigure lFigure = new LFigure(container, actionApprover, new LFigureBuilder());
            actionApprover.setFigure(lFigure);
            return lFigure;
        }
        return null;
    }
}
