package ca.khuddam.android_winter2016;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView topLine;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        root = findViewById(R.id.rootView);

        // Wire a connection to the top TextView
        topLine = (TextView)findViewById(R.id.top_line);

        topLine.setText(topLine.getText() + " - Some dynamic stuff I control");

        buttonOne = (Button)findViewById(R.id.button1);
        buttonTwo = (Button)findViewById(R.id.button2);
        buttonThree = (Button)findViewById(R.id.button3);

        // 1. Creating instances of Jacket from the blueprint defined in WinterJacket.java
        // 2. Setting jacket colors
        // 3. Assigning jacket's reference to buttons on activity

        // First jacket
        WinterJacket smallJacket = new WinterJacket();
        smallJacket.setColor(WinterJacket.JacketColor.BLUE);
        buttonOne.setTag(smallJacket);

        // Second jacket
        WinterJacket jacketTwo = new WinterJacket();
        jacketTwo.setColor(WinterJacket.JacketColor.GREEN);
        buttonTwo.setTag(jacketTwo);

        // Third jacket
        WinterJacket jacketThree = new WinterJacket();
        jacketThree.setColor(WinterJacket.JacketColor.RED);
        buttonThree.setTag(jacketThree);

        switch(smallJacket.getColor()) {
            // Set the topline text color based on jackcolor
            // using html type hex color values
            case BLACK: topLine.setTextColor(Color.BLACK); break;
            case BLUE: topLine.setTextColor(Color.BLUE); break;
            case RED: topLine.setTextColor(Color.RED); break;
        }

        // Assigning the onClickListener to each button
        buttonOne.setOnClickListener(buttonListener);
        buttonTwo.setOnClickListener(buttonListener);
        buttonThree.setOnClickListener(buttonListener);

        // Setting a OnLongClick Listener to open Second Activity on Long Press of first button
        buttonOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intentToOpenActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intentToOpenActivity);
                return false;
            }
        });
    }

    // A common OnClick Listener object that can be assigned to any Objects
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            WinterJacket jacket = (WinterJacket)v.getTag();
            root.setBackgroundColor(jacket.getAndroidColor());
        }
    };
}
