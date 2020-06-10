package org.academiadecodigo.gitbusters.bravoteam.figures;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;

public class Block extends Figure {

    public final static int SPEED = 1;

    public Block(GridPosition pos) {
        super(pos, FigureType.BLOCK);
    }

    @Override
    public void move() {
        for (int i = 0; i < 10; i++) {
            accelerate(GridDirection.LEFT, Block.SPEED);
            getPos().show();
        }
    }


    public void accelerate(GridDirection direction, int speed) {

        if (isCollided()) {
            // STOP

        }




        if (getPos().getCol() == 10) {
            getPos().hide();
        }

        // Accelerate in the choosen direction
        getPos().moveInDirection(direction, speed);

//        this.currentDirection = newDirection;
//        for (int i = 0; i < speed; i++) {
//            getPos().moveInDirection(newDirection, 1);
//            if (collisionDetector.isUnSafe(getPos())) {
//                crash();
//                break;
//            }
//        }

    }



}
