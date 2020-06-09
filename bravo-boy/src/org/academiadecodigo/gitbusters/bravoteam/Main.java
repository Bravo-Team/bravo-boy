package org.academiadecodigo.gitbusters.bravoteam;

import org.academiadecodigo.gitbusters.bravoteam.grid.GridType;

public class Main {
    public static void main(String[] args) {

        Game g = new Game(GridType.SIMPLE_GFX, 20, 12, 200);

        g.init();
    }
}
