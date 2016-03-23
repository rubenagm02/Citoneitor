package com.citoneitor.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citoneitor.R;

/**
 * Created by ruben on 23/03/16.
 */
public class FragmentProximasCitas extends Fragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_proximas_citas, container, false);

        return view;

    }
}
