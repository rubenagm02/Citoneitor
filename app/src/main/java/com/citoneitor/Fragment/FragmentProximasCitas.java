package com.citoneitor.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.citoneitor.Adaptadores.AdaptadorListaCitas;
import com.citoneitor.BaseDatos.BaseDatosObtener;
import com.citoneitor.R;

/**
 * Created by ruben on 23/03/16.
 */
public class FragmentProximasCitas extends Fragment {
    private Activity activity;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_proximas_citas, container, false);

        AdaptadorListaCitas adaptadorListaCitas =
                new AdaptadorListaCitas(activity,
                        new BaseDatosObtener(activity).obtenerCitasProximas());

        ListView listView = (ListView) view.findViewById(R.id.fragment_proximas_citas_lista);
        listView.setAdapter(adaptadorListaCitas);

        return view;

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
