package ca.khuddam.android_winter2016.fragments;


import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import ca.khuddam.android_winter2016.R;

/**
 * Created by RASHID on 2016-02-27.
 */
public class FragmentHandler extends Fragment {

    Fragment commonFragment;
    FragmentTransaction commonFragmentTransaction;
    View tabContainer;


    public FragmentHandler () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.content_fragment_handler, container, false);
        commonFragment = new JacketSelectorFragment();       // default Fragment is first fragment
        commonFragmentTransaction = getFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, commonFragment);
        commonFragmentTransaction.commit();

        tabContainer = (View)view.findViewById(R.id.fragmentContainer);
        final Button jacketButton = (Button)view.findViewById(R.id.redButton);
        final Button colorButton = (Button)view.findViewById(R.id.blueButton);
        final Button sizeButton = (Button)view.findViewById(R.id.yellowButton);

        final LinearLayout jacketLayout = (LinearLayout)view.findViewById(R.id.jacketLayout);
        final LinearLayout colorLayout = (LinearLayout)view.findViewById(R.id.colorLayout);
        final LinearLayout sizeLayout = (LinearLayout)view.findViewById(R.id.sizeLayout);

        jacketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jacketLayout.setBackgroundColor(Color.GREEN);   //  default button is first jacket button from left
                colorLayout.setBackgroundColor(Color.CYAN);
                sizeLayout.setBackgroundColor(Color.CYAN);

//                jacketButton.setTypeface(null, Typeface.BOLD);
//                colorButton.setTypeface(null, Typeface.NORMAL);
//                sizeButton.setTypeface(null, Typeface.NORMAL);

                commonFragment = new JacketSelectorFragment();
                commonFragmentTransaction = getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, commonFragment);
                commonFragmentTransaction.commit();
            }
        });

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jacketLayout.setBackgroundColor(Color.CYAN);
                colorLayout.setBackgroundColor(Color.GREEN);
                sizeLayout.setBackgroundColor(Color.CYAN);

//                jacketButton.setTypeface(null, Typeface.NORMAL);
//                colorButton.setTypeface(null, Typeface.BOLD);
//                sizeButton.setTypeface(null, Typeface.NORMAL);

                commonFragment = new SecondFragment();
                commonFragmentTransaction = getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, commonFragment);
                commonFragmentTransaction.commit();
            }
        });

        sizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jacketLayout.setBackgroundColor(Color.CYAN);
                colorLayout.setBackgroundColor(Color.CYAN);
                sizeLayout.setBackgroundColor(Color.GREEN);

//                jacketButton.setTypeface(null, Typeface.NORMAL);
//                colorButton.setTypeface(null, Typeface.NORMAL);
//                sizeButton.setTypeface(null, Typeface.BOLD);

                commonFragment = new ThirdFragment();
                commonFragmentTransaction = getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, commonFragment);
                commonFragmentTransaction.commit();
            }
        });

        return view;
    }
}

