package ca.khuddam.android_winter2016;

import android.graphics.Color;

/**
 * Created by roomisahi on 16-01-20.
 * Modified by Ehsan Elahi Malik on 26-Jan-2016     i) Added Green JacketColor  ii) Added "getColorInt()"
 */
public class WinterJacket {
    private JacketColor color = JacketColor.RED;
    public int coatLength;
    public int armLength;
    public int materialType;
    public String description;
    public float msrp;
    public boolean hasCap;

    public enum JacketColor {
        BLACK,
        RED,
        GREEN,
        BLUE
    }

    public void setColor(JacketColor theColor) {
        this.color = theColor;
    }

    public JacketColor getColor() {
        return color;
    }

    // Property to return the color as standard Color value in Int
    public int getColorInt(){
        switch (color) {
            case BLACK: return Color.BLACK;
            case RED: return Color.RED;
            case GREEN: return Color.GREEN;
            case BLUE: return Color.BLUE;
            default: return Color.WHITE;
        }
    }
}
