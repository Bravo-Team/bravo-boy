package org.academiadecodigo.gitbusters.bravoteam.figures;

import org.academiadecodigo.gitbusters.bravoteam.grid.Grid;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;

/**
 * Generic Figure, should be extended
 */
abstract public class Figure {

    private GridPosition pos;
    private Grid grid;
    private FigureType figureType;

    /**
     * Constructs a new figure
     *
     * @param pos     the initial figure position
     * @param figureType the figure type
     */
    public Figure(GridPosition pos, FigureType figureType){
        this.pos = pos;
        this.figureType = figureType;
    }

    /**
     * Perform specific moving behaviour according to the figure type
     */
    abstract void move();




    public GridPosition getPos() {
        return pos;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
