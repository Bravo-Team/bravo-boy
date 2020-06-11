package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.KeyboardListener.KeyboardListener;
import org.academiadecodigo.gitbusters.bravoteam.figures.*;
import org.academiadecodigo.gitbusters.bravoteam.grid.*;

public class Game {

    private Grid grid;
    private Block block;
    private Block upperBlock;
    private Hero hero;

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
     *
     * @param gridType which grid type to use
     * @param cols     number of columns in the grid
     * @param rows     number of rows in the grid
     * @param delay    animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    public void init() {

        grid.init();

        this.hero = new Hero(grid.makeGridPosition(2, 10, FigureType.HERO));
        this.block = new Block(grid.makeGridPosition(18, 10, FigureType.BLOCK));
        this.upperBlock = new Block(grid.makeGridPosition(18, 9, FigureType.BLOCK));

    }

    public void start() throws InterruptedException {

        new KeyboardListener(hero).setupKeys();

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            block.accelerate(GridDirection.LEFT, 1);
            upperBlock.accelerate(GridDirection.LEFT, 1);

            if (block.getPicture().getX() == -60) {
                block = new Block(grid.makeGridPosition(18, 10, FigureType.BLOCK));

            }

        }
    }

}