package ca.khuddam.android_winter2016.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import ca.khuddam.android_winter2016.fragments.FragmentHandler;
import ca.khuddam.android_winter2016.R;


public class FragmentHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Winter Jackets");
        setContentView(R.layout.activity_fragment_handler);



        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerHandler, new FragmentHandler()).commit();
        }

    }

}
