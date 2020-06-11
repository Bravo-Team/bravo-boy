package org.academiadecodigo.gitbusters.bravoteam.figures;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Hero is the player of the game
 */
public class Hero extends Figure {

    private int delay;

    /**
     * Constructs a new figure type Hero
     *
     * @param pos the initial figure position
     */
    public Hero(GridPosition pos) {
        super(pos, FigureType.HERO);

    }

    /**
     * @see Figure#move()
     */
    @Override
    void move() {

    }

    public void accelerate(GridDirection direction, int speed) {

        if (isCollided()) {
            // STOP

        }


        getPos().moveInDirection(GridDirection.UP, 1);


//        // Perform a U turn if we have bumped against the wall
//        if (isHittingWall()) {
//            newDirection = direction.oppositeDirection();
//        }
//
//        // Accelerate in the choosen direction
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
