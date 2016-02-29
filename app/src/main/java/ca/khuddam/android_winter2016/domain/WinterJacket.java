package ca.khuddam.android_winter2016.domain;

import android.graphics.Color;

/**
 * Created by roomisahi on 16-01-20.
 */
public class WinterJacket {

    /**
     *  Black = 1, White = 2, Red = 3
     */
    private JacketColor color = JacketColor.RED;
    public int coatLength;
    public int armLength;
    public int materialType;
    public String description;
    public float msrp;
    public boolean hasCap;

    public enum JacketColor {
        GREEN,
        BLACK,
        BLUE,
        RED
    }

    public void setColor(JacketColor theColor) {
        this.color = theColor;
    }

    public JacketColor getColor() {
        return color;
    }

    public int getAndroidColor() {
        switch (color) {
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case RED:
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }

}
