package ca.khuddam.android_winter2016;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by admin on 16-03-10.
 */
public class ColorFragment extends Fragment {

    LinearLayout rootLayout;
    TextView message;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_color, container, false);

        rootLayout = (LinearLayout) fragmentView.findViewById(R.id.color_fragment_root);
        WinterJacket selectedJacket = DataHolder.getInstance().getJacket();

        // Log.e("Creating Color Fragment", String.valueOf(selectedJacket.getAndroidColor()));
        if (selectedJacket != null) {
            rootLayout.setBackgroundColor(selectedJacket.getAndroidColor());
        }
        else
        {
            // Error - No jacket was selected.
            rootLayout.setBackgroundColor(Color.WHITE);
            message =  (TextView) fragmentView.findViewById(R.id.color_message);
            message.setText("Please select your Jacket first!");
        }

        return fragmentView;

    }

}
