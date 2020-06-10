package org.academiadecodigo.gitbusters.bravoteam.figures;

import org.academiadecodigo.gitbusters.bravoteam.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Hero is the player of the game
 */
public class Hero extends Figure {


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
}
