package com.citoneitor.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.citoneitor.BaseDatos.BaseDatosInsertar;
import com.citoneitor.Modelos.Servicio;
import com.citoneitor.R;

public class NuevoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_servicio);

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        final EditText editTextNombre = (EditText) findViewById(R.id.nuevo_servicio_nombre);
        final EditText editTextDuracion = (EditText) findViewById(R.id.nuevo_servicio_duracion);
        final EditText editTextCosto = (EditText) findViewById(R.id.nuevo_servicio_costo);

        //Se coloca el click del botón guardar
        findViewById(R.id.nuevo_servicio_guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDatosInsertar baseDatosInsertar = new BaseDatosInsertar(NuevoServicio.this);

                baseDatosInsertar.insertarServicio(new Servicio(
                        0,
                        editTextNombre.getText().toString(),
                        Double.parseDouble(editTextCosto.getText().toString()),
                        Integer.parseInt(editTextDuracion.getText().toString()),
                        ""
                ));

                Toast.makeText(NuevoServicio.this,
                        "Se ha guardado el servicio", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
