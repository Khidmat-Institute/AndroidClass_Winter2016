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

    final public static String LARGE = "large";
    final public static String MEDIUM = "medium";
    final public static String SMALL = "small";

    public int coatLength;
    public int armLength;
    public int materialType;
    public String description;
    public float msrp;
    public boolean hasCap;
    private String size;

    public enum JacketColor {
        BLACK,
        BLUE,
        RED,
        GREEN
    }


    public void setSize (String size)
    {
        this.size = size;
    }

    public String getSize()
    {
        return size;
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