package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridType;

public class Main {
    public static void main(String[] args) {

        Game g = new Game(GridType.SIMPLE_GFX, 80, 25, 200);

        g.init();
    }
}
