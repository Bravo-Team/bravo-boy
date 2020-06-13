package org.academiadecodigo.gitbusters.bravoteam.gameEngine;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardSetupRestart implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);
    private KeyboardEvent upKey = new KeyboardEvent();
    private GameTest gameTest;

    public KeyboardSetupRestart(GameTest gameTest) {
        this.gameTest = gameTest;
        setUpKey();
    }

    public void setUpKey() {
        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKey.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(upKey);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!gameTest.getIsRunning()) {
            gameTest.setRestartAvailable(true);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
