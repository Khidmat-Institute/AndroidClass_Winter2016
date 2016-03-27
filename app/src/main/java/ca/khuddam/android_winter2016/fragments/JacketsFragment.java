package ca.khuddam.android_winter2016.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.khuddam.android_winter2016.R;
import ca.khuddam.android_winter2016.domain.CommonDataHandler;
import ca.khuddam.android_winter2016.domain.WinterJacket;

/**
 * Created by RASHID on 2016-02-27.
 */
public class JacketsFragment extends Fragment {

    private Button jackBtn1;
    private Button jackBtn2;
    private Button jackBtn3;
//    private boolean isButton1Pressed = false;
//    private boolean isButton2Pressed = false;
//    private boolean isButton3Pressed = false;


    private WinterJacket commonWinterJacket;
    public CommonDataHandler winterJacketHolder;


    public JacketsFragment() {


        winterJacketHolder = CommonDataHandler.getCommonDataHandler();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Winter Jackets");

        View view = inflater.inflate(R.layout.jackets_fragment, container, false);
        jackBtn1 = (Button) view.findViewById(R.id.jacket1);
        jackBtn2 = (Button) view.findViewById(R.id.jacket2);
        jackBtn3 = (Button) view.findViewById(R.id.jacket3);

        if (winterJacketHolder != null) {
            if (winterJacketHolder.getWinterJacketType() == 2) {
                jackBtn2.setBackgroundResource(R.drawable.button_selected);
            } else if (winterJacketHolder.getWinterJacketType() == 3) {
                jackBtn3.setBackgroundResource(R.drawable.button_selected);
            } else {
                jackBtn1.setBackgroundResource(R.drawable.button_selected);
            }
        }

        jackBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jackBtn1.setBackgroundResource(R.drawable.button_selected);
                jackBtn2.setBackgroundResource(R.drawable.button_unselected);
                jackBtn3.setBackgroundResource(R.drawable.button_unselected);
//                jackBtn1.setText(isButtonReleased ? "PINK" : "BLUE");
                commonWinterJacket = new WinterJacket();
                commonWinterJacket.setColor(WinterJacket.JacketColor.BLUE);
                commonWinterJacket.setSize(WinterJacket.JacketSize.SMALL);
                winterJacketHolder.putWinterJacket(commonWinterJacket);
                winterJacketHolder.setWinterJacketType(1);
            }
        });

        jackBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jackBtn1.setBackgroundResource(R.drawable.button_unselected);
                jackBtn2.setBackgroundResource(R.drawable.button_selected);
                jackBtn3.setBackgroundResource(R.drawable.button_unselected);
//                jackBtn1.setText(isButtonReleased ? "PINK" : "BLUE");
                commonWinterJacket = new WinterJacket();
                commonWinterJacket.setColor(WinterJacket.JacketColor.RED);
                commonWinterJacket.setSize(WinterJacket.JacketSize.MEDIUM);
                winterJacketHolder.putWinterJacket(commonWinterJacket);
                winterJacketHolder.setWinterJacketType(2);
            }
        });

        jackBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jackBtn1.setBackgroundResource(R.drawable.button_unselected);
                jackBtn2.setBackgroundResource(R.drawable.button_unselected);
                jackBtn3.setBackgroundResource(R.drawable.button_selected);
//                jackBtn1.setText(isButtonReleased ? "PINK" : "BLUE");
                commonWinterJacket = new WinterJacket();
                commonWinterJacket.setColor(WinterJacket.JacketColor.GREEN);
                commonWinterJacket.setSize(WinterJacket.JacketSize.LARGE);
                winterJacketHolder.putWinterJacket(commonWinterJacket);
                winterJacketHolder.setWinterJacketType(3);
            }
        });

        return view;
    }



}
