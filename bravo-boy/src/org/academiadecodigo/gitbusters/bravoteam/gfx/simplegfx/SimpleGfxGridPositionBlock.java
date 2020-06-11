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

    public Picture getBlock() {
        return block;
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


        super.moveInDirection(direction, distance);


        block.translate(-10, 0);

        System.out.println("X: " + block.getX() );
    }


    public void setColor(GridPicture gridPicture) {
        super.setGridPicture(gridPicture);
    }

}
