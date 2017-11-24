package com.tetris.app.core;

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
                if (j == 0) {
                    result[i][j] = currentState[i][j] == null ? "|  " : "|*|";
                } else if (j == DIMENSION - 1) {
                    result[i][j] = currentState[i][j] == null ? "  |" : "|*|";
                } else {
                    result[i][j] = currentState[i][j] == null ? "   " : "|*|";
                }

            }
        }
        return result;
    }

    public int removeFullFilledLines() {
        int removed = 0;
        for (int i = 0; i < DIMENSION; i++) {
            if (removeLine(i)) {
                dropBlocksAboveLine(i);
                removed++;
            }
        }
        represent();
        return removed;
    }

    private boolean removeLine(int line) {
        if (countBlocksAtLine(line) == DIMENSION) {
            for (int j = 0; j < DIMENSION; j++) {
                removeBlocksAt(line, j);
            }
            return true;
        }
        return false;
    }

    private void removeBlocksAt(int y, int x) {
        figures.forEach(figure -> figure.removeBlock(y, x));
    }

    private void dropBlocksAboveLine(int line) {
        figures.forEach(f -> f.getBlocks().stream().filter(b -> b.getY() < line).forEach(b -> b.setY(b.getY() + 1)));
    }

    private int countBlocksAtLine(int line) {
        int count = 0;
        for (int j = 0; j < DIMENSION; j++) {
            if (currentState[line][j] != null) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        String[][] state = getStateAsStringArray();
        System.out.println("-----^-----");
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
