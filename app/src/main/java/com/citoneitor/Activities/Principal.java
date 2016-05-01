package com.citoneitor.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.citoneitor.Adaptadores.AdaptadorCitasTabs;
import com.citoneitor.LibreriaTabsSliding.SlidingTabLayout;
import com.citoneitor.R;

public class Principal extends AppCompatActivity {
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.principal_pager);

        //Se activa el click de abrir los clientes
        ImageView imageViewAbrirClientes = (ImageView) findViewById(R.id.principal_clientes);
        imageViewAbrirClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, Clientes.class);
                startActivity(intent);
            }
        });

        //Se agrega el botón de nueva cita
        ImageView imageViewNuevaCita = (ImageView) findViewById(R.id.principal_agregar_cita);

        imageViewNuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, NuevaCita.class);
                intent.putExtra("tipo", 0);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        //Se cargan las tabs
        AdaptadorCitasTabs adaptadorActividadesTabs = new AdaptadorCitasTabs(getSupportFragmentManager(), this);
        viewPager.setAdapter(adaptadorActividadesTabs);

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.principal_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(Color.rgb(201, 230, 227));
        slidingTabLayout.setViewPager(viewPager);
    }
}
