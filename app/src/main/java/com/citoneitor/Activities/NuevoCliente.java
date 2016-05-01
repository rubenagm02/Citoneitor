package com.citoneitor.Activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.citoneitor.Adaptadores.AdaptadorListaClientes;
import com.citoneitor.BaseDatos.BaseDatosInsertar;
import com.citoneitor.BaseDatos.BaseDatosObtener;
import com.citoneitor.Modelos.Cliente;
import com.citoneitor.R;

import java.util.ArrayList;
import java.util.Calendar;

public class NuevoCliente extends AppCompatActivity {

    private TextView textViewFechaNacimiento;
    private TextView textViewNombre;
    private TextView textViewApellidoPaterno;
    private TextView textViewApellidoMaterno;
    private TextView textViewTelefono;
    private ToggleButton toggleButtonSexo;
    private TextView textViewGuardar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cliente);

        //Se obtiene el contexto
        context = getApplicationContext();

        //se carga la barra de android por el xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.actividades_toolbar);
        setSupportActionBar(toolbar);

        //Se inicializan los componentes
        textViewFechaNacimiento = (TextView) findViewById(R.id.nuevo_cliente_fecha_nacimiento);
        textViewNombre = (TextView) findViewById(R.id.nuevo_cliente_nombre);
        textViewApellidoMaterno = (TextView) findViewById(R.id.nuevo_cliente_apellido_materno);
        textViewApellidoPaterno = (TextView) findViewById(R.id.nuevo_cliente_apellido_paterno);
        textViewTelefono = (TextView) findViewById(R.id.nuevo_cliente_telefono);
        textViewGuardar = (TextView) findViewById(R.id.nuevo_cliente_guardar);
        toggleButtonSexo = (ToggleButton) findViewById(R.id.nuevo_cliente_sexo);

        //Se coloca el click para la fecha de nacimiento
        textViewFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int anio = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int dia = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(NuevoCliente.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int anio,
                                                  int mes, int dia) {
                                textViewFechaNacimiento.setText(anio + "-"
                                        + (mes + 1) + "-" + dia);

                            }
                        }, anio, mes, dia);
                datePickerDialog.show();
            }
        });


        //Se guardan los datos
        textViewGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se saca el sexo como String
                String sexo = "Hombre";

                if (toggleButtonSexo.isChecked()) {
                    sexo = "Mujer";
                }

                BaseDatosInsertar baseDatosInsertar = new BaseDatosInsertar(NuevoCliente.this);
                baseDatosInsertar.insertarCliente(new Cliente(
                        0,
                        textViewNombre.getText().toString(),
                        textViewApellidoPaterno.getText().toString(),
                        textViewApellidoMaterno.getText().toString(),
                        sexo,
                        textViewFechaNacimiento.getText().toString(),
                        textViewTelefono.getText().toString(),
                        ""
                ));
                Toast.makeText(context, "Se ha guardado el cliente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}
