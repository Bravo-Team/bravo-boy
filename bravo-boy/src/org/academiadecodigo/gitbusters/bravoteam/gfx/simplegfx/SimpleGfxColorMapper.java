package org.academiadecodigo.gitbusters.bravoteam.gfx.simplegfx;


import org.academiadecodigo.gitbusters.bravoteam.grid.GridPicture;
import org.academiadecodigo.simplegraphics.graphics.Color;


public class SimpleGfxColorMapper {

    private static final GridPicture pictures[] = {
            GridPicture.HERO,
            GridPicture.BLOCK
    };

    public static String getPicturePath(GridPicture picture){

        String sGfxPicture = null;

        switch (picture) {
            case HERO:
                sGfxPicture = "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\hero.png";
                break;
            case BLOCK:
                sGfxPicture = "src\\org\\academiadecodigo\\gitbusters\\bravoteam\\resources\\block.png";
                break;
            default:
                System.out.println("something went terribly wrong...");
        }

        return sGfxPicture;
    }
}
