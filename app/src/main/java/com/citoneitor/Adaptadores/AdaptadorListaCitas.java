package com.citoneitor.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.citoneitor.BaseDatos.BaseDatosObtener;
import com.citoneitor.Modelos.Cita;
import com.citoneitor.Modelos.Cliente;
import com.citoneitor.Modelos.Servicio;
import com.citoneitor.R;

import java.util.ArrayList;

/**
 * Created by root on 1/05/16.
 */
public class AdaptadorListaCitas extends ArrayAdapter<Cita> {

    private BaseDatosObtener baseDatosObtener;
    public AdaptadorListaCitas(Context context, ArrayList<Cita> citas) {
        super(context, R.layout.item_cita, citas);
        baseDatosObtener = new BaseDatosObtener(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        convertView = vi.inflate(R.layout.item_cita, null);

        Cita cita = getItem(position);

        Cliente cliente = baseDatosObtener.obtenerClientes(cita.getIdCliente());
        Servicio servicio = baseDatosObtener.obtenerServicios(cita.getServicio());

        ((TextView) convertView.findViewById(R.id.item_cita_nombre)).setText(
                cliente.getNombre() + " "
                        + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno()
        );

        ((TextView) convertView.findViewById(R.id.item_cita_hora)).setText("Hora: " + cita.getHora().substring(0, 5) + " hrs.");

        ((TextView) convertView.findViewById(R.id.item_cita_servicio)).setText(servicio.getNombre());
        return convertView;
    }
}
