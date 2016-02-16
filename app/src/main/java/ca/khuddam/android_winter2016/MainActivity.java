package ca.khuddam.android_winter2016;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
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

        // Creating an actual instance of a Jacket from the blueprint
        // that we defined in WinterJacket.java
        WinterJacket smallJacket = new WinterJacket();
        smallJacket.setColor(WinterJacket.JacketColor.BLUE);

        // second jacket
        WinterJacket jacketTwo = new WinterJacket();
        jacketTwo.setColor(WinterJacket.JacketColor.GREEN);

        // third jacket
        WinterJacket jacketThree = new WinterJacket();
        jacketThree.setColor(WinterJacket.JacketColor.RED);

        buttonThree.setBackgroundColor(Color.BLUE);
        // associate jackets with the buttons
        buttonOne.setTag(smallJacket);
        buttonTwo.setTag(jacketTwo);
        buttonThree.setTag(jacketThree);
/*        buttonThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button1) return;
                buttonHandler(v);
            }
        });*/
//        buttonThree.setOnClickListener();
        buttonThree.setOnTouchListener(btnTouch);

        switch(smallJacket.getColor()) {
            // Set the topline text color based on jackcolor
            // using html type hex color values
            case BLACK: topLine.setTextColor(Color.BLACK); break;
            case BLUE: topLine.setTextColor(Color.BLUE); break;
            case RED: topLine.setTextColor(Color.RED); break;
        }


    }

    public void buttonHandler(View clickedView) {
        WinterJacket jacket = (WinterJacket)clickedView.getTag();
//        root.setBackgroundColor(jacket.getAndroidColor());
        buttonThree.setBackgroundColor(Color.RED);
    }

    private View.OnTouchListener btnTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();

            if (v.getId() == R.id.button1) return false;

            else if (v.getId() == R.id.button2) {
                if (action == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
//                    new SecondActivity();
                }
            }
            else if (v.getId() == R.id.button3) {
                if (action == MotionEvent.ACTION_DOWN) {
                    buttonThree.setBackgroundColor(Color.RED);
                } else if (action == MotionEvent.ACTION_UP) {
                    buttonThree.setBackgroundColor(Color.BLUE);
                }
            }
            return false;
        }

    };

}
