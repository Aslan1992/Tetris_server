package com.tetris.app;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;
import com.tetris.app.figures.SpacePose;
import com.tetris.app.figures.impls.TFigure;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class TFigureTest {

    @Test
    public void shouldNotInitializeFigure_atUpLeftCorner() {
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
    public void shouldNotInitializeFigure_atRightUpCorner() {
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
    public void shouldNotInitializeFigure_atDownLeftCorner() {
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
    public void shouldNotInitializeFigure_atDownRightCorner() {
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
    public void shouldTurnAround_whenNoBlocksSurroundPrevent() {
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
    public void shouldNotTurnAround_whenSomeBlockPrevents() throws InterruptedException {
        //Given
        Container container = new Container();
        Figure figure = new TFigure(container);
        figure.init(4,4, SpacePose.FOURTH);
        container.addFigure(figure);

//        Figure one = new BlockFigure();
//        one.init(5, 2, SpacePose.FIRST);
//        container.addFigure(one);



        container.represent();container.print();
        //When


        while (true) {
            Thread.sleep(500);
            figure.turnAround();
            container.represent();
            container.print();
            Thread.sleep(500);
            figure.moveLeft();
            container.represent();
            container.print();
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
