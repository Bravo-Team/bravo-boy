package org.academiadecodigo.gitbusters.bravoteam.gameEngine;

import org.academiadecodigo.gitbusters.bravoteam.Sound;
import org.academiadecodigo.gitbusters.bravoteam.Utility.Random;
import org.academiadecodigo.gitbusters.bravoteam.figures.Block;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameTest {

    private static final int CANVAS_WEIGHT = 960;
    private static final int CANVAS_HEIGHT = 540;
    private static final int CELLSIZE = 50;
    private static final int PADDING = 10;
    private static final int jumpHeight = -200;
    private boolean jump;
    private boolean inAir;
    private boolean isRunning = true;
    private boolean onGrounded = true;
    private Picture hero;
    private Picture background;
    private Picture ground;
    private Picture block;
    private Picture block1;
    private int increment = PADDING;
    private int random1 = Random.getRandomNum(1, 400);
    private int random2 = Random.getRandomNum(1, 400);
    private int random3 = Random.getRandomNum(1, 400);
    private int random4 = Random.getRandomNum(1, 400);
    private int random5 = Random.getRandomNum(1, 400);
    private Sound gamePlayMusic;
    private Sound gameOverSound;
    private Sound gameOverHit;
    private Sound menuMusic;
    private Picture gameOver;
    private Picture menuImage;
    private boolean isInMenu = true;



    public GameTest() {
        new KeyboardSetup(this);
        Rectangle CANVAS = new Rectangle(PADDING,PADDING,CANVAS_WEIGHT,CANVAS_HEIGHT);
        CANVAS.draw();
        initMenu();
    }



    public void outMenu(){
        isInMenu = false;
    }

    public void initMenu(){
        new KeyboardSetupMenu(this);
        menuImage = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\startimg.png");
        menuImage.draw();
        menuMusic = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\menuSong.wav");
        menuMusic.play(false);
    }

    public void update() throws InterruptedException {

        menuImage.delete();
        menuMusic.stop();

        Sound gamePlayMusic = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\GamePlayMusic.wav");
        gamePlayMusic.setLoop(1000);
        gamePlayMusic.play(false);

        while (isRunning) {

            Thread.sleep(10);

            if (hero == null && background == null && ground == null && block == null) {
                drawInitialGraphics();
            }

            if (jump && onGrounded) {
                hero.translate(0, -5);
                onGrounded = false;
                inAir = true;
            }

            if (inAir && hero.getY() > 290) {
                hero.translate(0, -15);
                if (hero.getY() == 290) {
                    inAir = false;
                }
            } else if (hero.getY() == 490) {
                onGrounded = true;
                jump = false;

            }

            if (hero.getY() < 490) {
                hero.translate(0, 5);
            }


            if (block != null) {
                if (block.getX() == random1) {
                    block1 = new Picture(CANVAS_WEIGHT - CELLSIZE, 490, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
                    block1.draw();
                }
            }

            if(block != null) {
                if (block.getX() == 0) {
                    block.delete();
                    block = null;
                }
            }
            if (block == null && block1 != null){
                if (block1.getX() == random1) {
                    block = new Picture(CANVAS_WEIGHT - CELLSIZE, 490, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
                    block.draw();
                }
            }

            if (block1 != null) {
                if (block1.getX() == 0) {
                    block1.delete();
                }
            }

            if (block1 != null) {
                block1.translate(-5, 0);
            }

            if (block != null) {
                block.translate(-5, 0);
            }

            if (block1 != null){
                if (hero.getX() >= block1.getX() - 30 && hero.getX() <= block1.getX() + 30 && hero.getY() <= block1.getY() && hero.getY() >= block1.getY() - 50){
                    int x = hero.getX();
                    int y = hero.getY();
                    hero.delete();
                    hero = new Picture(x, y, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\deadHero.png");
                    hero.draw();
                    gameOver = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\gameover2.png");
                    gameOver.draw();
                    isRunning = false;
                    gamePlayMusic.stop();
                    gameOverHit = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\punchHit.wav");
                    gameOverHit.play(false);
                    gameOverSound = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\gameOver.wav");
                    gameOverSound.play(false);
                }
            }

            if (block != null){
                if (hero.getX() >= block.getX() - 30 && hero.getX() <= block.getX() + 30 && hero.getY() <= block.getY() && hero.getY() >= block.getY() - 50){
                    int x = hero.getX();
                    int y = hero.getY();
                    hero.delete();
                    hero = new Picture(x, y, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\deadHero.png");
                    hero.draw();
                    gameOver = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\gameover2.png");
                    gameOver.draw();
                    isRunning = false;
                    gamePlayMusic.stop();
                    gameOverHit = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\punchHit.wav");
                    gameOverHit.play(false);
                    gameOverSound = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\gameOver.wav");
                    gameOverSound.play(false);
                }
            }
        }

    }

    public void jump() {

        jump = true;
    }

    private void drawInitialGraphics() {

        background = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\background.gif");
        background.draw();

        for (int i = 0; i < 19; i++) {
            ground = new Picture(increment, CANVAS_HEIGHT, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\ground-tile.png");
            ground.draw();
            increment += 50;
        }

        hero = new Picture(150, 490, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\hero.png");
        hero.draw();

        block = new Picture(CANVAS_WEIGHT - CELLSIZE, 490, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
        block.draw();

    }


}
