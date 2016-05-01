package com.citoneitor.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.citoneitor.Modelos.Servicio;
import com.citoneitor.R;

import java.util.ArrayList;

/**
 * Created by root on 1/05/16.
 */
public class AdaptadorListaServicios extends ArrayAdapter<Servicio> {

    private Activity activity;
    private int tipo;
    private Intent intent;

    public AdaptadorListaServicios(Activity context, ArrayList<Servicio> servicios, int tipo, Intent intent) {
        super(context, R.layout.item_servicio, servicios);
        activity = context;
        this.tipo = tipo;
        this.intent = intent;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        convertView = vi.inflate(R.layout.item_servicio, null);

        final Servicio servicio = getItem(position);

        ((TextView) convertView.findViewById(R.id.item_servicio_nombre)).setText(servicio.getNombre());
        ((TextView) convertView.findViewById(R.id.item_servicio_duracion)).
                setText("Duración: " + servicio.getDuracion() + " minutos");
        ((TextView) convertView.findViewById(R.id.item_servicio_costo)).
                setText("Costo: $" + servicio.getCosto());


        if (tipo == 1) {
            convertView.findViewById(R.id.item_servicio_click).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("Nombre", servicio.getNombre());
                    intent.putExtra("Id", servicio.getId());

                    activity.setResult(1, intent);
                    activity.finish();
                }
            });
        }

        return convertView;
    }
}
