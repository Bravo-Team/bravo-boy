package org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridColor;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        simpleGfxGrid = (SimpleGfxGrid) getGrid();
        this.rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()) , grid.getCellSize(),  grid.getCellSize());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = (SimpleGfxGrid) getGrid();

        this.rectangle = new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(),  grid.getCellSize());
        rectangle.draw();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int x1 = simpleGfxGrid.columnToX(getCol());
        int y1 = simpleGfxGrid.rowToY(getRow());

        super.moveInDirection(direction, distance);

        int x2 = simpleGfxGrid.columnToX(getCol());
        int y2 = simpleGfxGrid.rowToY(getRow());

        rectangle.translate(x2 - x1, y2 - y1);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }

}
