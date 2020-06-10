package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.figures.*;
import org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.gitbusters.bravoteam.grid.*;

import java.util.Random;

public class Game {

    private Grid grid;
    private Block block;
    private Block block1;


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

        Figure hero = new Hero(grid.makeGridPosition(2, 10, FigureType.HERO));
        Block block = new Block(grid.makeGridPosition(18, 10, FigureType.BLOCK));

//        Block block1 = new Block(grid.makeGridPosition(7, 10, FigureType.BLOCK));

        this.block = block;
//        this.block1 = block1;


    }

    public void start() throws InterruptedException {
        SimpleGfxGrid simpleGfxGrid = (SimpleGfxGrid) grid;

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            block.accelerate(GridDirection.LEFT, 1);
//            block1.accelerate(GridDirection.LEFT, 1);

            for (int i = 0; i < 100; i++) {
                System.out.println(simpleGfxGrid.columnToX(block.getPos().getCol()));
//                int numRand = (int) Math.round(Math.random() * 400);

                if (simpleGfxGrid.columnToX(block.getPos().getCol()) == 10) {
                    System.out.println("entrou no cu do tony");
//                    Block block1 = new Block(grid.makeGridPosition(18, 10, FigureType.BLOCK));
//                    this.block1 = block1;
                }

            }


        }
    }

}