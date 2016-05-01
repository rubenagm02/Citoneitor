package com.citoneitor.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.citoneitor.Adaptadores.AdaptadorListaServicios;
import com.citoneitor.BaseDatos.BaseDatosObtener;
import com.citoneitor.R;

public class Servicios extends AppCompatActivity {

    private ListView listView;
    private Activity activity;
    private ImageView imageViewAgregarServicio;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        activity = this;
        intent = getIntent();

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        //Se inicializan los componentes
        listView = (ListView) findViewById(R.id.servicios_lista);
        imageViewAgregarServicio = (ImageView) findViewById(R.id.servicios_agregar_servicio);

        //El click para agregar un servicio
        imageViewAgregarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Servicios.this, NuevoServicio.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();

        AdaptadorListaServicios adaptadorListaServicios =
                new AdaptadorListaServicios(activity,
                        new BaseDatosObtener(activity).obtenerServicios(), 1, intent);

        listView.setAdapter(adaptadorListaServicios);
    }
}
