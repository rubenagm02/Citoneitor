package com.citoneitor.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.citoneitor.BaseDatos.BaseDatosInsertar;
import com.citoneitor.Modelos.Cita;
import com.citoneitor.R;

import java.util.Calendar;
import java.util.Date;

public class NuevaCita extends AppCompatActivity {

    private TextView textViewSeleccionaCliente;
    private TextView textViewSeleccionaServicio;
    private TextView textViewGuardar;
    private DatePicker datePickerFecha;
    private TimePicker timePickerHora;
    private String hora;
    private String fecha;
    private int idCliente;
    private int idServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        //Se inicializan las variables
        textViewSeleccionaCliente = (TextView) findViewById(R.id.nueva_cita_selecciona_cliente);
        textViewSeleccionaServicio = (TextView) findViewById(R.id.nueva_cita_servicio);
        datePickerFecha = (DatePicker) findViewById(R.id.nueva_cita_fecha);
        timePickerHora = (TimePicker) findViewById(R.id.nueva_cita_hora);
        textViewGuardar = (TextView) findViewById(R.id.nueva_cita_guardar);

        //Se pone el click de seleccionar cliente
        textViewSeleccionaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevaCita.this, Clientes.class);
                intent.putExtra("tipo", 1);
                startActivityForResult(intent, 2);
            }
        });

        //Se pone el click del servicio
        textViewSeleccionaServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevaCita.this, Servicios.class);
                intent.putExtra("tipo", 1);
                startActivityForResult(intent, 3);
            }
        });

        //Se coloca el click de guardar cita
        textViewGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se obtiene la fecha
                String dia = "" + datePickerFecha.getDayOfMonth();
                String mes = (datePickerFecha.getMonth() + 1) + "";

                if (dia.length() == 1) {
                    dia = "0" + dia;
                }

                if (mes.length() == 1) {
                    mes = "0" + mes;
                }

                fecha = datePickerFecha.getYear() + "-" + mes + "-" +dia;

                BaseDatosInsertar baseDatosInsertar = new BaseDatosInsertar(NuevaCita.this);
                baseDatosInsertar.insertarCita(new Cita(0,
                        fecha,
                        idCliente,
                        1,
                        "Próxima",
                        105.5,
                        hora,
                        idServicio));
                Toast.makeText(NuevaCita.this, "Se ha guardado la cita", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        //Cuando se cambia el timePicker
        timePickerHora.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                String minuto = minute + "";

                if (minuto.length() == 1) {
                    minuto = "0" + minuto;
                }

                String horaT = hourOfDay + "";

                if (horaT.length() == 1) {
                    horaT = "0" + horaT;
                }
                hora = horaT + ":" + minuto + ":00";
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == 1){
            textViewSeleccionaCliente.setText(data.getExtras().getString("Nombre"));
            idCliente = data.getExtras().getInt("Id");
        } else if (requestCode == 3 && resultCode == 1) {
            textViewSeleccionaServicio.setText(data.getExtras().getString("Nombre"));
            idServicio = data.getExtras().getInt("Id");
        }

    }
}
