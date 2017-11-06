package com.tetris.app.presentation;

import com.tetris.app.figures.Block;
import com.tetris.app.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class Container {

    public final static int DIMENSION = 10;
    private List<Figure> figures;
    private Block[][] currentState;

    public Container() {
        figures = new ArrayList<>();
        currentState = new Block[DIMENSION][DIMENSION];
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public Block[][] getCurrentState() {
        return currentState;
    }

    public void represent() {
        clear();
        for (Figure figure : figures) {
            for (Block block : figure.getBlocks()) {
                currentState[block.getY()][block.getX()] = block;
            }
        }
    }

    public String[][] getStateAsStringArray() {
        String[][] result = new String[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                result[i][j] = currentState[i][j] == null ? "[ ]" : "[*]";
            }
        }
        return result;
    }

    public void print() {
        String[][] state = getStateAsStringArray();
        System.out.println("---^---");
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(state[i][j]);
            }
            System.out.println();
        }
    }

    private void clear() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                currentState[i][j] = null;
            }
        }
    }

}
