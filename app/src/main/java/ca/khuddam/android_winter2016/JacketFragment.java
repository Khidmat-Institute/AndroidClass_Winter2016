package ca.khuddam.android_winter2016;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by admin on 16-03-10.
 */
public class JacketFragment extends Fragment {
    public static int count = 0;
    View btnOne, btnTwo, btnThree;
    LinearLayout rootLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_jacket, container, false);

        // Wire a connection to the top TextView
        btnOne = (View)fragmentView.findViewById(R.id.btn_one);
        btnTwo = (View)fragmentView.findViewById(R.id.btn_two);
        btnThree = (View)fragmentView.findViewById(R.id.btn_three);
        rootLayout = (LinearLayout) fragmentView.findViewById(R.id.rootView);

        rootLayout.setBackgroundColor(Color.WHITE);

        WinterJacket redJacket = new WinterJacket();
        WinterJacket greenJacket =new WinterJacket();
        WinterJacket blueJacket = new WinterJacket();

        redJacket.setColor(WinterJacket.JacketColor.RED);
        redJacket.setSize(WinterJacket.MEDIUM);

        greenJacket.setColor(WinterJacket.JacketColor.GREEN);
        greenJacket.setSize(WinterJacket.LARGE);

        blueJacket.setColor(WinterJacket.JacketColor.BLUE);
        blueJacket.setSize(WinterJacket.SMALL);

        btnOne.setTag(redJacket);
        btnTwo.setTag(greenJacket);
        btnThree.setTag(blueJacket);

        //Log.e("WinterJacket1 Color", String.valueOf(redJacket.getAndroidColor()));
        //Log.e("WinterJacket2 Color", String.valueOf(greenJacket.getAndroidColor()));
        //Log.e("WinterJacket3 Color", String.valueOf(blueJacket.getAndroidColor()));



        WinterJacket savedJacket = (WinterJacket) DataHolder.getInstance().getJacket();
        if (savedJacket != null) {
            int buttonID = DataHolder.getInstance().getButtonId();
            //Log.e("Saved Button Id = " , String.valueOf(buttonID));
            //Log.e("Button 1 Id  = ", String.valueOf(R.id.btn_one));
            //Log.e("Button 2 Id  = ", String.valueOf(R.id.btn_two));
            //Log.e("Button 3 Id  = ", String.valueOf(R.id.btn_three));


            View selectedButton = (View) fragmentView.findViewById(buttonID);
            selectedButton.setSelected(true);
        }



        // Defining the Touch Listeners for the three buttons
        btnOne.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View clickedButton, MotionEvent event) {
                btnTwo.setSelected(false);
                btnThree.setSelected(false);
                saveSelectedJacketData(clickedButton);
                return false;
            }
        });

        btnTwo.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View clickedButton, MotionEvent event) {
                btnOne.setSelected(false);
                btnThree.setSelected(false);
                saveSelectedJacketData(clickedButton);
                return false;
            }
        });

        btnThree.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View clickedButton, MotionEvent event) {
                btnOne.setSelected(false);
                btnTwo.setSelected(false);
                saveSelectedJacketData(clickedButton);
                return false;
            }
        });


        return fragmentView;

    }


    private void saveSelectedJacketData(View clickedButton)
    {
        WinterJacket associtedJacket = (WinterJacket) clickedButton.getTag();
        DataHolder.getInstance().setJacket(associtedJacket);
        DataHolder.getInstance().setButtonId(clickedButton.getId());
    }

}



