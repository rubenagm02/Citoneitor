package com.citoneitor.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.citoneitor.Adaptadores.AdaptadorListaClientes;
import com.citoneitor.BaseDatos.BaseDatosObtener;
import com.citoneitor.R;

public class Clientes extends AppCompatActivity {

    private Activity context;
    private ListView listViewClientes;
    private Intent intent;
    private int tipo = 0; //0 clientes //1 es seleccionar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        //Se obtiene el contexto
        context = this;

        //Se inicializa la lista
        listViewClientes = (ListView) findViewById(R.id.clientes_lista);

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.clientes_agregar_cliente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, NuevoCliente.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.clientes_atras).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intent = getIntent();

        try {
            tipo = getIntent().getExtras().getInt("tipo");
        } catch (Exception e){

        }
    }


    @Override
    public void onResume(){
        super.onResume();

        AdaptadorListaClientes adaptadorListaClientes =
                new AdaptadorListaClientes(context,
                        new BaseDatosObtener(context).obtenerClientes(), tipo, intent);

        listViewClientes.setAdapter(adaptadorListaClientes);
    }
}
