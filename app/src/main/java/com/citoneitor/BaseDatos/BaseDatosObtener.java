package com.citoneitor.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.citoneitor.Modelos.Cita;
import com.citoneitor.Modelos.Cliente;
import com.citoneitor.Modelos.Servicio;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by root on 30/04/16.
 */
public class BaseDatosObtener extends SQLiteOpenHelper {

    public BaseDatosObtener(Context context) {
        super(context, "Citoneitor", null, 1);;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Querys.crearTablas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Cliente> obtenerClientes () {
        ArrayList<Cliente> clientes = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Querys.OBTENER_CLIENTES, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            clientes.add(new Cliente(
                cursor.getInt(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Nombre")),
                    cursor.getString(cursor.getColumnIndex("ApellidoPaterno")),
                    cursor.getString(cursor.getColumnIndex("ApellidoMaterno")),
                    cursor.getString(cursor.getColumnIndex("Sexo")),
                    cursor.getString(cursor.getColumnIndex("FechaNacimiento")),
                    cursor.getString(cursor.getColumnIndex("Telefono")),
                    cursor.getString(cursor.getColumnIndex("Observaciones"))
            ));

            cursor.moveToNext();
        }

        cursor.close();

        return clientes;
    }

    public Cliente obtenerClientes (int idCliente) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Querys.OBTENER_CLIENTES + " WHERE Id = " + idCliente, null);
        cursor.moveToFirst();
        Cliente cliente = new Cliente(
                cursor.getInt(cursor.getColumnIndex("Id")),
                cursor.getString(cursor.getColumnIndex("Nombre")),
                cursor.getString(cursor.getColumnIndex("ApellidoPaterno")),
                cursor.getString(cursor.getColumnIndex("ApellidoMaterno")),
                cursor.getString(cursor.getColumnIndex("Sexo")),
                cursor.getString(cursor.getColumnIndex("FechaNacimiento")),
                cursor.getString(cursor.getColumnIndex("Telefono")),
                cursor.getString(cursor.getColumnIndex("Observaciones"))
        );

        cursor.close();

        return cliente;
    }

    public ArrayList<Servicio> obtenerServicios () {
        ArrayList<Servicio> servicios = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Querys.OBTENER_SERVICIOS, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            servicios.add(new Servicio(
                    cursor.getInt(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Nombre")),
                    cursor.getDouble(cursor.getColumnIndex("Costo")),
                    cursor.getInt(cursor.getColumnIndex("Duracion")),
                    cursor.getString(cursor.getColumnIndex("Observaciones"))
            ));

            cursor.moveToNext();
        }

        cursor.close();

        return servicios;
    }

    public Servicio obtenerServicios (int idServicio) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Querys.OBTENER_SERVICIOS + " WHERE Id = " + idServicio, null);
        cursor.moveToFirst();

        Servicio servicio = new Servicio(
                cursor.getInt(cursor.getColumnIndex("Id")),
                cursor.getString(cursor.getColumnIndex("Nombre")),
                cursor.getDouble(cursor.getColumnIndex("Costo")),
                cursor.getInt(cursor.getColumnIndex("Duracion")),
                cursor.getString(cursor.getColumnIndex("Observaciones"))
        );

        cursor.close();

        return servicio;
    }

    public ArrayList<Cita> obtenerCitasProximas () {
        ArrayList<Cita> citas = new ArrayList<>();


        String query = Querys.OBTENER_CITAS_PROXIMAS
                + " WHERE Fecha >= '" + obtenerFechaActual()
                + "'";//+"' AND Hora >= '" + obtenerHoraActual() +"' ORDER BY Fecha, Hora";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            citas.add(new Cita(
                    cursor.getInt(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Fecha")),
                    cursor.getInt(cursor.getColumnIndex("IdCliente")),
                    cursor.getInt(cursor.getColumnIndex("TipoCita")),
                    cursor.getString(cursor.getColumnIndex("EstatusCita")),
                    cursor.getDouble(cursor.getColumnIndex("Costo")),
                    cursor.getString(cursor.getColumnIndex("Hora")),
                    cursor.getInt(cursor.getColumnIndex("Servicio"))
            ));

            cursor.moveToNext();
        }

        cursor.close();

        return citas;
    }

    public ArrayList<Cita> obtenerCitasPasadas () {
        ArrayList<Cita> citas = new ArrayList<>();


        String query = Querys.OBTENER_CITAS_PROXIMAS
                + " WHERE Fecha <= '" + obtenerFechaActual()
                + "'";//+"' AND Hora >= '" + obtenerHoraActual() +"' ORDER BY Fecha, Hora";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            citas.add(new Cita(
                    cursor.getInt(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Fecha")),
                    cursor.getInt(cursor.getColumnIndex("IdCliente")),
                    cursor.getInt(cursor.getColumnIndex("TipoCita")),
                    cursor.getString(cursor.getColumnIndex("EstatusCita")),
                    cursor.getDouble(cursor.getColumnIndex("Costo")),
                    cursor.getString(cursor.getColumnIndex("Hora")),
                    cursor.getInt(cursor.getColumnIndex("Servicio"))
            ));

            cursor.moveToNext();
        }

        cursor.close();

        return citas;
    }

    private String obtenerFechaActual () {
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        String mes = calendar.get(Calendar.MONTH) + "";

        if (mes.length() == 1) {
            mes = "0" + mes;
        }

        String dia = (calendar.get(Calendar.DAY_OF_MONTH) + 1) + "";

        if (dia.length() == 1) {
            dia = "0" + dia;
        }

        return anio + "-" + mes + "-" + dia;
    }

    public String obtenerHoraActual () {
        Calendar calendar = Calendar.getInstance();
        String hora = (calendar.get(Calendar.HOUR_OF_DAY) + 1) + "";

        if (hora.length() == 1) {
            hora = "0" + hora;
        }

        String minutos = calendar.get(Calendar.MINUTE) + "";

        if (minutos.length() == 1) {
            minutos = "0" + minutos;
        }

        return hora + ":" + minutos + ":00";
    }
}
