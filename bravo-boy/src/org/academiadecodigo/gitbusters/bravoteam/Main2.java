package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.gameEngine.GameTest;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
//        Game2 g = new Game2(GridType.SIMPLE_GFX, 20, 12, 10);
//
//        g.init2();
//        g.start2();


        GameTest gameTest = new GameTest();

        while (true) {
            if (gameTest.getRestartAvailable()) {
                gameTest.stopGameOverMusic();
                gameTest = new GameTest();
            }
        }


    }
}
