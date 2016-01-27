package ca.khuddam.android_winter2016;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView topLine;
        // Wire a connection to the top TextView
        topLine = (TextView) findViewById(R.id.top_line);

        topLine.setText(topLine.getText());

        // Creating an actual instance of a Jacket from the blueprint
        // that we defined in WinterJacket.java
        WinterJacket smallJacket = new WinterJacket();
        smallJacket.setColor(WinterJacket.JacketColor.BLUE);

        switch (smallJacket.getColor()) {
            // Set the topline text color based on jackcolor
            // using html type hex color values
            case BLACK:
                topLine.setTextColor(Color.BLACK);
                break;
            case BLUE:
                topLine.setTextColor(Color.BLUE);
                break;
            case RED:
                topLine.setTextColor(Color.RED);
                break;

        }

    }
}





