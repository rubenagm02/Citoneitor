package com.citoneitor.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.citoneitor.Modelos.Cita;
import com.citoneitor.Modelos.Cliente;
import com.citoneitor.Modelos.Servicio;

import static com.citoneitor.BaseDatos.Querys.TAG;

/**
 * Created by root on 30/04/16.
 */
public class BaseDatosInsertar extends SQLiteOpenHelper {

    public BaseDatosInsertar(Context context) {
        super(context, "Citoneitor", null, 1);;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Querys.crearTablas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarCliente (Cliente cliente) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nombre", cliente.getNombre());
        contentValues.put("ApellidoPaterno", cliente.getApellidoPaterno());
        contentValues.put("ApellidoMaterno", cliente.getApellidoMaterno());
        contentValues.put("Sexo", cliente.getSexo());
        contentValues.put("FechaNacimiento", cliente.getFechaNacimiento());
        contentValues.put("Telefono", cliente.getTelefono());
        contentValues.put("Observaciones", cliente.getObservaciones());

        sqLiteDatabase.insert("Cliente", null, contentValues);

        Log.i(TAG, "Se ha insertado un cliente");
    }

    public void insertarCita (Cita cita) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Fecha", cita.getFecha());
        contentValues.put("IdCliente", cita.getIdCliente());
        contentValues.put("TipoCita", cita.getTipoCita());
        contentValues.put("EstatusCita", cita.getIdEstatusCita());
        contentValues.put("Costo", cita.getCosto());
        contentValues.put("Hora", cita.getHora());
        contentValues.put("Servicio", cita.getServicio());

        sqLiteDatabase.insert("Cita", null, contentValues);

        Log.i(TAG, "Se ha insertado una cita");
    }

    public void insertarServicio (Servicio servicio) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nombre", servicio.getNombre());
        contentValues.put("Costo", servicio.getCosto());
        contentValues.put("Duracion", servicio.getDuracion());
        contentValues.put("Observaciones", servicio.getObservaciones());

        sqLiteDatabase.insert("Servicio", null, contentValues);

        Log.i(TAG, "Se ha insertado un servicio");
    }
}
