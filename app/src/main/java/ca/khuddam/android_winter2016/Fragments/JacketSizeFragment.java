package ca.khuddam.android_winter2016.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ca.khuddam.android_winter2016.R;
import ca.khuddam.android_winter2016.domain.CommonDataHandler;

/**
 * Created by RASHID on 2016-02-27.
 */
public class JacketSizeFragment extends Fragment {

    public JacketSizeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Jacket Size");

        View view = inflater.inflate(R.layout.jacketsize_fragment, container , false);
        final TextView sizeText = (TextView)view.findViewById(R.id.sizeTextView);

        CommonDataHandler winterJacketHolder = CommonDataHandler.getCommonDataHandler();

        sizeText.setText(winterJacketHolder.getWinterJacket().getSize().toString());

        return view;

    }
}
