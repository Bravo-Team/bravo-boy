package org.academiadecodigo.gitbusters.bravoteam.gameEngine;

import org.academiadecodigo.gitbusters.bravoteam.Sound;
import org.academiadecodigo.gitbusters.bravoteam.Utility.Random;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameTest {

    private static final int CANVAS_WIDTH = 960;
    private static final int CANVAS_HEIGHT = 540;
    private static final int ROW_LEVEL = 490;
    private static final int JUMP_LEVEL = 290;
    private static final int CELLSIZE = 50;
    private static final int PADDING = 10;
    private boolean jump;
    private boolean inAir;
    private boolean isRunning = true;
    private boolean onGrounded = true;
    private Picture hero;
    private Picture background;
    private Picture ground;
    private Picture block;
    private Picture block1;
    private Picture block2;
    private int increment = PADDING;
    private int random1 = Random.getRandomNum(1, 400);
    private int random2 = Random.getRandomNum(1, 400);
    private int random3 = Random.getRandomNum(400, 500);
    private Sound gamePlayMusic;
    private Sound gameOverSound;
    private Sound gameOverHit;
    private Sound menuMusic;
    private Text score;
    private Picture gameOver;
    private Picture menuImage;
    private boolean isInMenu = true;
    private boolean startGame = false;
    private boolean restartAvailable = false;
    private Integer difficultyCounter = 0;

    public GameTest() throws InterruptedException {
        new KeyboardSetupRestart(this);
        new KeyboardSetupMenu(this);
        new KeyboardSetup(this);
        Rectangle CANVAS = new Rectangle(PADDING, PADDING, CANVAS_WIDTH, CANVAS_HEIGHT);
        CANVAS.draw();
        update();
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void stopGameOverMusic() {
        gameOverHit.stop();
        gameOverSound.stop();
    }

    public void setRestartAvailable(boolean restartAvailable) {
        this.restartAvailable = restartAvailable;
    }

    public boolean getRestartAvailable() {
        return restartAvailable;
    }


    public void startGame() {
        startGame = true;
    }

    public void initMenu() {
        menuImage = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\startimg.png");
        menuImage.draw();
        menuMusic = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\menuSong.wav");
        menuMusic.play(false);
    }

    public void update() throws InterruptedException {


        while (isRunning) {
            Thread.sleep(10);

            if (isInMenu) {
                initMenu();
                isInMenu = false;
            }


            if (startGame) {

                if (hero == null && background == null && ground == null && block == null) {
                    drawInitialGraphics();
                }

                if (jump && onGrounded) {
                    hero.translate(0, -5);
                    onGrounded = false;
                    inAir = true;
                    Sound jump = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\jump.wav");
                    jump.play(false);
                }

                if (inAir && hero.getY() > JUMP_LEVEL) {
                    hero.translate(0, -15);
                    if (hero.getY() == JUMP_LEVEL) {
                        inAir = false;
                    }

                } else if (hero.getY() == ROW_LEVEL) {
                    onGrounded = true;
                    jump = false;

                }

                if (hero.getY() < ROW_LEVEL) {
                    hero.translate(0, 5);
                }

                if (block1 == null && block != null) {
                    if (block.getX() == 70) {
                        block1 = new Picture(CANVAS_WIDTH - CELLSIZE, ROW_LEVEL, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
                        block1.draw();
                    }
                }

                if (block != null) {
                    if (block.getX() <= 0) {
                        block.delete();
                        block = null;
                        difficultyCounter++;
                        score.delete();
                        score = new Text(835,50,"SCORE: " + difficultyCounter.toString());
                        score.grow(70,25);
                        score.setColor(Color.WHITE);
                        score.draw();
                    }
                }


                if (block == null && block2 != null) {
                    if (block2.getX() == 210) {
                        block = new Picture(CANVAS_WIDTH - CELLSIZE, ROW_LEVEL, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
                        block.draw();
                    }
                }

                if (block2 == null && block1 != null) {
                    if (block1.getX() == 350) {
                        block2 = new Picture(CANVAS_WIDTH - CELLSIZE, ROW_LEVEL, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
                        block2.draw();
                    }
                }

                if (block1 != null) {
                    if (block1.getX() <= 0) {
                        block1.delete();
                        block1 = null;
                        difficultyCounter++;
                        score.delete();
                        score = new Text(835,50,"SCORE: " + difficultyCounter.toString());
                        score.grow(70,25);
                        score.setColor(Color.WHITE);
                        score.draw();
                    }
                }

                if (block2 != null) {
                    if (block2.getX() <= 0) {
                        block2.delete();
                        block2 = null;
                        difficultyCounter++;
                        score.delete();
                        score = new Text(835,50,"SCORE: " + difficultyCounter.toString());
                        score.grow(70,25);
                        score.setColor(Color.WHITE);
                        score.draw();
                    }
                }

                if (block1 != null) {
                    if (difficultyCounter < 5) {
                        block1.translate(-5, 0);
                    } else if (difficultyCounter >= 5 && difficultyCounter < 15) {
                        block1.translate(-7, 0);
                    } else {
                        block1.translate(-10, 0);
                    }
                }

                if (block != null) {
                    if (difficultyCounter < 5) {
                        block.translate(-5, 0);
                    } else if (difficultyCounter >= 5 && difficultyCounter < 15) {
                        block.translate(-7, 0);
                    } else {
                        block.translate(-10, 0);
                    }
                }

                if (block2 != null) {
                    if (difficultyCounter < 5) {
                        block2.translate(-5, 0);
                    } else if (difficultyCounter >= 5 && difficultyCounter < 15) {
                        block2.translate(-7, 0);
                    } else {
                        block2.translate(-10, 0);
                    }
                }

                if (block2 != null) {
                    if (hero.getX() >= block2.getX() - 30 && hero.getX() <= block2.getX() + 30 && hero.getY() <= block2.getY() && hero.getY() >= block2.getY() - 50) {
                        int x = hero.getX();
                        int y = hero.getY();
                        hero.delete();
                        hero = new Picture(x, y, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\deadHero.png");
                        hero.draw();
                        gameOver = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\gameover2.png");
                        gameOver.draw();
                        isRunning = false;
                        if (gamePlayMusic != null)
                            gamePlayMusic.stop();
                        gameOverHit = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\punchHit.wav");
                        gameOverHit.play(false);
                        gameOverSound = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\gameOver.wav");
                        gameOverSound.play(false);
                    }
                }

                if (block1 != null) {
                    if (hero.getX() >= block1.getX() - 30 && hero.getX() <= block1.getX() + 30 && hero.getY() <= block1.getY() && hero.getY() >= block1.getY() - 50) {
                        int x = hero.getX();
                        int y = hero.getY();
                        hero.delete();
                        hero = new Picture(x, y, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\deadHero.png");
                        hero.draw();
                        gameOver = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\gameover2.png");
                        gameOver.draw();
                        isRunning = false;
                        if (gamePlayMusic != null)
                            gamePlayMusic.stop();
                        gameOverHit = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\punchHit.wav");
                        gameOverHit.play(false);
                        gameOverSound = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\gameOver.wav");
                        gameOverSound.play(false);
                    }
                }

                if (block != null) {
                    if (hero.getX() >= block.getX() - 30 && hero.getX() <= block.getX() + 30 && hero.getY() <= block.getY() && hero.getY() >= block.getY() - 50) {
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

    }

    public void jump() {

        jump = true;
    }

    public void drawInitialGraphics() {

        isInMenu = false;
        menuImage.delete();
        menuMusic.stop();


        this.gamePlayMusic = new Sound("src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\music\\GamePlayMusic.wav");
        gamePlayMusic.setLoop(1000);
        gamePlayMusic.play(false);

        background = new Picture(PADDING, PADDING, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\background.gif");
        background.draw();

        for (int i = 0; i < 19; i++) {
            ground = new Picture(increment, CANVAS_HEIGHT, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\ground-tile.png");
            ground.draw();
            increment += 50;
        }

        score = new Text(835,50,"SCORE: " + difficultyCounter.toString());
        score.grow(70,25);
        score.setColor(Color.WHITE);
        score.draw();

        hero = new Picture(150, ROW_LEVEL, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\hero.png");
        hero.draw();

        block = new Picture(CANVAS_WIDTH - CELLSIZE, ROW_LEVEL, "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png");
        block.draw();

    }


}
