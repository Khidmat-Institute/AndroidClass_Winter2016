package ca.khuddam.android_winter2016;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView topLine;
    Button btnOne, btnTwo, btnThree;
    FrameLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire a connection to the top TextView
        topLine = (TextView)findViewById(R.id.top_line);
        btnOne=(Button)findViewById(R.id.btnOne);
        btnTwo=(Button)findViewById(R.id.btnTwo);
        btnThree=(Button)findViewById(R.id.btnThree);
        rootLayout=(FrameLayout)findViewById(R.id.rootView);


        topLine.setText(topLine.getText() + " - Some dynamic stuff I control");

        // Creating an actual instance of a Jacket from the blueprint
        // that we defined in WinterJacket.java
        WinterJacket redJacket = new WinterJacket();
        WinterJacket greenJacket =new WinterJacket();
        WinterJacket blueJacket = new WinterJacket();

        redJacket.setColor(WinterJacket.JacketColor.RED);
        greenJacket.setColor(WinterJacket.JacketColor.GREEN);
        blueJacket.setColor(WinterJacket.JacketColor.BLUE);

        btnOne.setTag(redJacket);
        btnTwo.setTag(greenJacket);
        btnThree.setTag(blueJacket);
        /*switch(smallJacket.getColor()) {
            // Set the topline text color based on jackcolor
            // using html type hex color values
            case BLACK: topLine.setTextColor(Color.BLACK); break;
            case BLUE: topLine.setTextColor(Color.BLUE); break;
            case RED: topLine.setTextColor(Color.RED); break;
        }*/
    }

    public void btnClick(View clickedButton){
        WinterJacket associtedJacket=(WinterJacket)clickedButton.getTag();
        rootLayout.setBackgroundColor(associtedJacket.getAndroidColor());

    }
}