package ca.khuddam.android_winter2016;

/**
 * Created by admin on 16-03-11.
 **/


public class DataHolder {

    private static DataHolder dataObject = null;
    private WinterJacket jacket = null;
    private int buttonId = -1;

    private DataHolder() {
        // Can't be instantiated
    }

    public static DataHolder getInstance() {
        if (dataObject == null)
            dataObject = new DataHolder();
        return dataObject;
    }


    public WinterJacket getJacket() {

        // if (jacket != null)
        //    Log.e("Get Jacket", String.valueOf(jacket.getAndroidColor()));

        return jacket;
    }

    public void setJacket(WinterJacket winterJacket) {
        this.jacket = winterJacket;
        // Log.e("Set Jacket", String.valueOf(jacket.getAndroidColor()));
    }

    public void setButtonId(int id)
    {
        buttonId = id;
    }

    public int getButtonId()
    {
        return buttonId;
    }
}