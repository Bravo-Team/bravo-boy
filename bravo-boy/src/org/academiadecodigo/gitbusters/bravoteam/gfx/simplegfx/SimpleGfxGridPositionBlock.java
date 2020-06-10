package org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridPicture;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.AbstractGridPosition;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPositionBlock extends AbstractGridPosition {

    private Picture block;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPositionBlock(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);

        simpleGfxGrid = (SimpleGfxGrid) getGrid();


        this.block = new Picture(grid.columnToX(getCol()), grid.rowToYWithoutPad(row), "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
        block.draw();


    }


    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {

        block.draw();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {

        block.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

//        int x1 = simpleGfxGrid.columnToX(getCol());
//        int y1 = simpleGfxGrid.rowToY(getRow());
//
//        super.moveInDirection(direction, distance);
//
//        int x2 = simpleGfxGrid.columnToX(getCol());
//        int y2 = simpleGfxGrid.rowToY(getRow());
//
//        rectangle.translate(x2 - x1, y2 - y1);
    }


    public void setColor(GridPicture gridPicture) {
        super.setGridPicture(gridPicture);
    }

}
