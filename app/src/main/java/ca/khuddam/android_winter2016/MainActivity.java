package ca.khuddam.android_winter2016;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView firstTab, secondTab, thirdTab;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTab = (TextView) findViewById(R.id.tab_jackets);
        secondTab = (TextView) findViewById(R.id.tab_color);
        thirdTab = (TextView) findViewById(R.id.tab_size);

        container = (FrameLayout) findViewById(R.id.fragment_container);



        // OnTouchListener Event for each of the Tabs - Works with one touch.

        firstTab.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                JacketFragment fragment = new JacketFragment();
                fragmentTransaction.add(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

                return false;
            }
        });


        secondTab.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ColorFragment fragment = new ColorFragment();
                fragmentTransaction.add(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

                return false;
            }
        });

        thirdTab.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SizeFragment fragment = new SizeFragment();
                fragmentTransaction.add(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

                return false;
            }
        });

        // Note: onClickListener didn't seem to register a click unless the
        // tabs (TextView + Icon) were clicked twice.
    }
}
