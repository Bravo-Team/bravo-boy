package org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx;

import org.academiadecodigo.gitbusters.bravoteam.figures.FigureType;
import org.academiadecodigo.gitbusters.bravoteam.grid.Grid;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridPicture;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private final int cellSize = 50;
    private final int cols;
    private final int rows;
    private Picture background;


    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        this.background = new Picture(PADDING, PADDING*2, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\background.gif");
        background.draw();


        for (int i = 0; i < 19; i++) {
            Picture floor = new Picture(columnToX(i),rowToY(11),"src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\ground-tile.png");
            floor.draw();
        }

    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return background.getWidth();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return background.getHeight();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return background.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return background.getY();
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }





    @Override
    public GridPosition makeGridPosition(int col, int row, FigureType figureType) {
//        GridPosition position = new SimpleGfxGridPositionHero(col, row, this);
        switch (figureType) {
            case HERO:
                return new SimpleGfxGridPositionHero(col, row, this);
            case BLOCK:
                return new SimpleGfxGridPositionBlock(col, row, this);
        }
        return null;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return row * cellSize + PADDING;
    }

    public int rowToYWithoutPad(int row) {
        return row * cellSize;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column * cellSize + PADDING;
    }
}
