package org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridPicture;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPositionHero extends AbstractGridPosition {

    private Picture hero;

    private SimpleGfxGrid simpleGfxGrid;


    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPositionHero(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);

        simpleGfxGrid = (SimpleGfxGrid) getGrid();

        this.hero = new Picture(grid.columnToX(col), grid.rowToY(row), "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\hero.png");
        hero.draw();


    }


    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        hero.draw();

    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        hero.delete();

    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

//        int x1 = simpleGfxGrid.columnToX(getCol());
//        int y1 = simpleGfxGrid.rowToY(getRow());
//

//
//        int x2 = simpleGfxGrid.columnToX(getCol());
//        int y2 = simpleGfxGrid.rowToY(getRow());
//

        super.moveInDirection(direction, distance);

        hero.translate(0, -110);


        if (hero.getY() == 400){
//            for (int i = 0; i < 110; i++) {
                hero.translate(0,1);
//            }
        }



    }


    public void setColor(GridPicture gridPicture) {
        super.setGridPicture(gridPicture);
    }

}
