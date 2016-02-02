package ca.khuddam.android_winter2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RelativeLayout root = (RelativeLayout)findViewById(R.id.second_activity_root);

        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intentOpenFirstActicity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentOpenFirstActicity);
                return false;
            }
        });
    }
}
