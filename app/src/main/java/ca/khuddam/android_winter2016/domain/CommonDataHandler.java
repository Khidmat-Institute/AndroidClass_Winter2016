package ca.khuddam.android_winter2016.domain;

/**
 * Created by RASHID on 2016-03-27.
 */
public class CommonDataHandler {

    private static CommonDataHandler sInstance = null;

    private int winterJacketType;
    private WinterJacket theWinterJacket;

    private CommonDataHandler() {

    }


    public static CommonDataHandler getCommonDataHandler() {

        if (sInstance == null) {

            sInstance = new CommonDataHandler();

        }

        return sInstance;

    }

    public void putWinterJacket(WinterJacket jacket) {

        theWinterJacket = jacket;

//        theWinterJacket.save(jacket);

    }

    public WinterJacket getWinterJacket() {

        // retrieve the winterJacket from a database

        return theWinterJacket;

    }

    public int getWinterJacketType() {
        return winterJacketType;
    }

    public void setWinterJacketType(int winterJacketType) {
        this.winterJacketType = winterJacketType;
    }
}
