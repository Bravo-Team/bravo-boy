package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.gameEngine.GameTest;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        GameTest gameTest = new GameTest();

        while (true) {
            if (gameTest.getRestartAvailable()) {
                gameTest.stopGameOverMusic();
                gameTest = new GameTest();
            }
        }


    }
}
