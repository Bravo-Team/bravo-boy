package org.academiadecodigo.gitbusters.bravoteam.figures;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;

public class Block extends Figure {


    public Block(GridPosition pos) {
        super(pos, FigureType.BLOCK);
    }

    @Override
    void move() {

    }


    public void accelerate(GridDirection direction, int speed) {

        if (isCollided()) {
            // STOP

        }


        GridDirection newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(newDirection, 1);
            if (collisionDetector.isUnSafe(getPos())) {
                crash();
                break;
            }
        }

    }



}
