package com.tetris.app;

import com.tetris.app.exceptions.FigureInitException;
import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.BlockFigure;
import com.tetris.app.figures.impls.TFigure;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class TFigureTest {

    @Test
    public void shouldNotInitializeFigure_atUpLeftCorner() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        container.addFigure(figure);
        //When
        figure.init(0,0, SpacePose.FIRST);
        container.represent();
        container.print();
        //Then
         assertThatAllElementsAreNull(container.getCurrentState());
    }

    @Test
    public void shouldNotInitializeFigure_atRightUpCorner() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        container.addFigure(figure);
        //When
        figure.init(0,9, SpacePose.FIRST);
        container.represent();
        container.print();
        //Then
        assertThatAllElementsAreNull(container.getCurrentState());
    }

    @Test
    public void shouldNotInitializeFigure_atDownLeftCorner() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        container.addFigure(figure);
        //When
        figure.init(9,0, SpacePose.FIRST);
        container.represent();
        container.print();
        //Then
        assertThatAllElementsAreNull(container.getCurrentState());
    }

    @Test
    public void shouldNotInitializeFigure_atDownRightCorner() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        container.addFigure(figure);
        //When
        figure.init(9,9, SpacePose.FIRST);
        container.represent();
        container.print();
        //Then
        assertThatAllElementsAreNull(container.getCurrentState());
    }

    @Test
    public void shouldTurnAround_whenNoBlocksSurroundPrevent() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        figure.init(4,4, SpacePose.FIRST);
        container.addFigure(figure);
        container.represent();container.print();
        //When
        figure.moveForward();
        //Then
        container.represent();container.print();
    }

    @Test
    public void shouldNotTurnAroundFromFirstPose_whenSomeBlockPrevents() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        figure.init(2,2, SpacePose.FIRST);
        container.addFigure(figure);

        Figure one = new BlockFigure();
        //uncomment for 4 cases
        //one.init(1, 1, null;
        //one.init(3, 1, null);
//        one.init(3, 2, null);
        one.init(2, 3, null);
        container.addFigure(one);

        container.represent();container.print();
        //When
        figure.turnAround();
        container.represent();container.print();
    }

    @Test
    public void shouldNotTurnAroundFromSecondPose_whenSomeBlockPrevents() throws FigureInitException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        figure.init(2,2, SpacePose.SECOND);
        container.addFigure(figure);

        Figure one = new BlockFigure();
        //uncomment for 4 cases
        //one.init(1, 1, null;
        //one.init(3, 1, null);
//        one.init(3, 2, null);
        one.init(2, 3, null);
        container.addFigure(one);

        container.represent();container.print();
        //When
        figure.turnAround();
        container.represent();container.print();
    }

    @Test
    public void t() throws InterruptedException, FigureInitException {
        Container container = new Container();


        while (true) {
            Figure figure1 = new TFigure(container);
            figure1.init(1,1, SpacePose.FIRST);
            container.addFigure(figure1);
            container.represent();
            container.print();
            int k = 0;
            while (k < 8) {
                figure1.moveForward();
                container.represent();
                container.print();
                k++;
                Thread.sleep(1000);
                System.out.print("\033[H\033[2J");
            }
        }
    }


    private void assertThatAllElementsAreNull(Block[][] state) {
        for(int i = 0; i < Container.DIMENSION; i++) {
            for (int j = 0; j < Container.DIMENSION; j++) {
                assertNull(state[i][j]);
            }
        }
    }

}
