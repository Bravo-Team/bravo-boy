package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.figures.*;
import org.academiadecodigo.gitbusters.bravoteam.grid.Grid;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridFactory;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridType;

public class Game {

    private Grid grid;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedFigures = 4;

    /**
     * Constructs a new game
     * @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    public void init() {

        grid.init();
//
        Figure hero = new Hero(grid.makeGridPosition(2, 10));
//        Figure block = new Block(grid.makeGridPosition());


    }

}