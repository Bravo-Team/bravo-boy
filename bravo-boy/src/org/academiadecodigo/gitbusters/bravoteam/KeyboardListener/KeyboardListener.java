package org.academiadecodigo.gitbusters.bravoteam.KeyboardListener;

import org.academiadecodigo.gitbusters.bravoteam.figures.Hero;
import org.academiadecodigo.gitbusters.bravoteam.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Hero hero;


    public KeyboardListener(Hero hero) {
        this.hero = hero;
    }

    public void setupKeys() {


        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        hero.accelerate(GridDirection.UP, 1);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }


}
