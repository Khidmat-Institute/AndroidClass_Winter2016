package ca.khuddam.android_winter2016;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    TextView topLine;
    WinterJacket smallJacket, mediumJacket, largeJacket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire a connection to the top TextView
        //topLine = (TextView)findViewById(R.id.top_line);
        //topLine.setText(topLine.getText() + " - Some dynamic stuff I control");

        // Creating an actual instance of a Jacket from the blueprint
        // that we defined in WinterJacket.java
        smallJacket = new WinterJacket();
        smallJacket.setColor(WinterJacket.JacketColor.BLUE);

        // Updates by Waseem N. for assignment 2

        // Create a medium sized jacket in RED color.
        mediumJacket = new WinterJacket();
        mediumJacket.setColor(WinterJacket.JacketColor.RED);

        // Create a large sized jacket in BLACK color.
        largeJacket = new WinterJacket();
        mediumJacket.setColor(WinterJacket.JacketColor.BLACK);
    }

    public void onSmallButtonClick(View view){
        //Change the background to the colour of the small jacket
        LinearLayout LL;
        LL = (LinearLayout) findViewById(R.id.Layout);
        LL.setBackgroundColor( getColorValue(smallJacket.getColor()));
    }

    public void onMediumButtonClick(View view){
        //Change the background to the colour of the medium jacket
        LinearLayout LL;
        LL = (LinearLayout) findViewById(R.id.Layout);
        LL.setBackgroundColor( getColorValue(mediumJacket.getColor()));
    }

    public void onLargeButtonClick(View view){
        //Change the background to the colour of the medium jacket
        LinearLayout LL;
        LL = (LinearLayout) findViewById(R.id.Layout);
        LL.setBackgroundColor( getColorValue(largeJacket.getColor()));
    }


    /**
     *
     * @param jc The colour of the Jacket.
     * @return Returns the corresponding int color value of the Jacket.
     */
    private int getColorValue(WinterJacket.JacketColor jc)
    {
        int col;
        switch(jc) {

            case BLACK:
                col =  Color.BLACK;
                break;
            case RED:
                col = Color.RED;
                break;
            case BLUE:
                col = Color.BLUE;
                break;
            default:
                col= Color.BLACK;
                break;
        }
        return col;

    }
}
