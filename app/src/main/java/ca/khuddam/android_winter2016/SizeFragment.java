package ca.khuddam.android_winter2016;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by admin on 16-03-10.
 */
public class SizeFragment extends Fragment {

    LinearLayout rootLayout;
    TextView jacketSizeCaption;
    ImageView jacketSizeImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_size, container, false);

        rootLayout = (LinearLayout) fragmentView.findViewById(R.id.size_fragment_root);
        jacketSizeCaption = (TextView) fragmentView.findViewById(R.id.jacket_size_text);
        jacketSizeImage = (ImageView) fragmentView.findViewById(R.id.jacket_size_image);
        rootLayout.setBackgroundColor(Color.WHITE);

        WinterJacket selectedJacket = DataHolder.getInstance().getJacket();

        // Log.e("Creating Color Fragment", String.valueOf(selectedJacket.getAndroidColor()));
        if (selectedJacket != null) {

            if (selectedJacket.getSize().equals(WinterJacket.SMALL)) {
                jacketSizeImage.setImageResource(R.drawable.small_jacket);
                jacketSizeCaption.setText(WinterJacket.SMALL);
            }
            else if (selectedJacket.getSize().equals(WinterJacket.MEDIUM)) {
                jacketSizeImage.setImageResource(R.drawable.medium_jacket);
                jacketSizeCaption.setText(WinterJacket.MEDIUM);
            }
            else if (selectedJacket.getSize().equals(WinterJacket.LARGE)) {
                jacketSizeImage.setImageResource(R.drawable.large_jacket);
                jacketSizeCaption.setText(WinterJacket.LARGE);
            }
        }
        else
        {
            // Error - No jacket was selected.
            jacketSizeCaption.setText("Please select your Jacket first!");
        }

        return fragmentView;

    }

}
