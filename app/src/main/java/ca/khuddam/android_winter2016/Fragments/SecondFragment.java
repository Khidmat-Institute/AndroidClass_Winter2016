package ca.khuddam.android_winter2016.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.khuddam.android_winter2016.R;

/**
 * Created by RASHID on 2016-02-27.
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Jacket Color");
        return inflater.inflate(R.layout.content_fragment_second, container , false);
    }
}
