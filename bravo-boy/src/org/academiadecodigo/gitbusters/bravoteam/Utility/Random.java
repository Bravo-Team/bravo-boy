package org.academiadecodigo.gitbusters.bravoteam.Utility;

public class Random {

    public static int getRandomNum(int min, int max){
        int random = (int)Math.floor(Math.random()* (max - min) + min);
        while (random % 5 != 0){
            random = (int)Math.floor(Math.random()* (max - min) + min);
        }
        return random;
    }
}
