package ca.khuddam.android_winter2016;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity  {

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

    }

    private void InitView() {
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);


        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(TAB_1_TAG),
                R.drawable.tab_indicator_gen,"First",R.drawable.genres_icon),Tab1Container.class,null);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(TAB_2_TAG),
                R.drawable.tab_indicator_gen,"Second",R.drawable.genres_icon),Tab2Container.class,null);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(TAB_3_TAG),
                R.drawable.tab_indicator_gen,"Third",R.drawable.genres_icon),Tab3Container.class,null);


    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();

        if (currentTabTag.equals(TAB_1_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_1_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_2_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_2_TAG)).popFragment();
        }
        else if (currentTabTag.equals(TAB_3_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_3_TAG)).popFragment();
        }

        if (!isPopFragment) {
            finish();
        }
    }

    private TabSpec setIndicator(Context ctx, TabSpec spec,
                                 int resid, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        v.setBackgroundResource(resid);
        TextView tv = (TextView)v.findViewById(R.id.txt_tabtxt);
        ImageView img = (ImageView)v.findViewById(R.id.img_tabtxt);

        tv.setText(string);
        img.setBackgroundResource(genresIcon);
        return spec.setIndicator(v);
    }


}



/*
public class MainActivity extends FragmentActivity {


    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private FragmentTabHost mTabHost;

    TextView topLine;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    View root;




        root = findViewById(R.id.rootView);

        // Wire a connection to the top TextView
        topLine = (TextView) findViewById(R.id.top_line);

        topLine.setText(topLine.getText() + " - Some dynamic stuff I control");

        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonThree = (Button) findViewById(R.id.button3);

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

        // associate jackets with the buttons
        buttonOne.setTag(smallJacket);
        buttonTwo.setTag(jacketTwo);
        buttonThree.setTag(jacketThree);

        // Intent for Second Activity
        final Intent intent = new Intent(this, SecondActivity.class);


        // Add click listeners for the three buttons separately.
        // Implementing the ClickListener interface is also an option.
        buttonOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View clickedView) {
                startActivity(intent);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                WinterJacket jacket = (WinterJacket) clickedView.getTag();
                root.setBackgroundColor(jacket.getAndroidColor());
            }
        });


        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                WinterJacket jacket = (WinterJacket) clickedView.getTag();
                root.setBackgroundColor(jacket.getAndroidColor());
            }
        });

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

} */
