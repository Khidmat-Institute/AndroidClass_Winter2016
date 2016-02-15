package ca.khuddam.android_winter2016;

import android.graphics.Color;

/**
 * Created by roomisahi on 16-01-20.
 */
public class WinterJacket {

    /**
     *  Black = 1, White = 2, Red = 3
     */
    private JacketColor color = JacketColor.BLACK;
    public int coatLength;
    public int armLength;
    public int materialType;
    public String description;
    public float msrp;
    public boolean hasCap;

    public enum JacketColor {
        BLACK,
        BLUE,
        RED,
        GREEN
    }

    public void setColor(JacketColor theColor) {
        this.color = theColor;
    }

    public JacketColor getColor() {
        return color;
    }
    public int getAndroidColor(){
        switch(color){
            case BLUE:return Color.BLUE;
            case GREEN:return Color.GREEN;
            case RED:return Color.RED;
            default:return Color.BLACK;
        }
    }
}