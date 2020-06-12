package org.academiadecodigo.gitbusters.bravoteam.gameEngine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameTest {

    private static final int CANVAS_WEIGHT = 960;
    private static final int CANVAS_HEIGHT = 540;
    private static final int CELLSIZE = 50;
    private static final int PADDING = 10;
    private static final int jumpHeight = -50;
    private boolean jump;
    private boolean isRunning = true;
    private boolean onGrounded = true;
    private Picture hero;
    private Picture background;
    private Picture ground;
    private Picture block;
    private int increment = PADDING;

    public GameTest() throws InterruptedException {
        new KeyboardSetup(this);
        Rectangle CANVAS = new Rectangle(PADDING, PADDING, CANVAS_WEIGHT, CANVAS_HEIGHT);
        CANVAS.draw();
        update();
    }

    public void update() throws InterruptedException {

        while (isRunning) {

            Thread.sleep(20);
            if (hero == null || background == null || ground == null || block == null) {
                drawInitialGraphics();
            }

            if (jump && onGrounded) {
                hero.translate(0, jumpHeight);
                jump = false;
                onGrounded = false;
            }

            if (hero.getY() < 420) {
                hero.translate(0, 5);

            } else {
                onGrounded = true;
            }

            block.translate(-10, 0);
        }

    }

    public void jump() {

        jump = true;
    }

    private void drawInitialGraphics() {

        background = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\background.gif");
        background.draw();

        for (int i = 0; i < 19; i++) {
            ground = new Picture(increment, CANVAS_HEIGHT ,"src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\ground-tile.png");
            ground.draw();
            increment += 50;
        }

        hero = new Picture(50, CANVAS_HEIGHT - CELLSIZE, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\hero.png");
        hero.draw();

        block = new Picture(CANVAS_WEIGHT - CELLSIZE , 480, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
        block.draw();

    }


}
