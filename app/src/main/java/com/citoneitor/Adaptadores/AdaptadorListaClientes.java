package com.citoneitor.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.citoneitor.Modelos.Cliente;
import com.citoneitor.R;

import java.util.ArrayList;

/**
 * Created by root on 30/04/16.
 */
public class AdaptadorListaClientes extends ArrayAdapter<Cliente>{

    private int tipo;
    private  Activity activity;
    private Intent intent;

    public AdaptadorListaClientes(Activity context, ArrayList<Cliente> clientes, int tipo, Intent intent) {
        super(context, R.layout.item_cliente, clientes);
        activity = context;
        this.intent = intent;
        this.tipo = tipo;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        convertView = vi.inflate(R.layout.item_cliente, null);

        final Cliente cliente = getItem(position);

        ((TextView) convertView.findViewById(R.id.item_cliente_nombre)).setText(cliente.getNombre()
                + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());

        if (cliente.getSexo().equals("Hombre")) {
            (convertView.findViewById(R.id.item_cliente_color_sexo)).setBackgroundResource(R.color.colorAzul);
            ((ImageView) convertView.findViewById(R.id.item_cliente_imagen)).setImageResource(R.drawable.default_perfil_hombre);
        } else {
            (convertView.findViewById(R.id.item_cliente_color_sexo)).setBackgroundResource(R.color.colorRosa);
            ((ImageView) convertView.findViewById(R.id.item_cliente_imagen)).setImageResource(R.drawable.default_perfil_mujer);
        }

        if (tipo == 1) {
            convertView.findViewById(R.id.item_cliente_click).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent.putExtra("Nombre", cliente.getApellidoPaterno()
                            + " " + cliente.getApellidoMaterno() + " " + cliente.getNombre());

                    intent.putExtra("Id", cliente.getId());

                    activity.setResult(1, intent);
                    activity.finish();
                }
            });
        }

        return convertView;
    }

}
