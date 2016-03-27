package ca.khuddam.android_winter2016.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ca.khuddam.android_winter2016.R;
import ca.khuddam.android_winter2016.domain.CommonDataHandler;

/**
 * Created by RASHID on 2016-02-27.
 */
public class JacketColorFragment extends Fragment {

    public JacketColorFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Jacket Color");
        View view = inflater.inflate(R.layout.jacketcolor_fragment, container, false);
        final RelativeLayout colorContainerLayout = (RelativeLayout)view.findViewById(R.id.colorContainerLayout);

        CommonDataHandler winterJacketHolder = CommonDataHandler.getCommonDataHandler();

        colorContainerLayout.setBackgroundColor(winterJacketHolder.getWinterJacket().getAndroidColor());

        return view;
    }
}
