package com.citoneitor.BaseDatos;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 30/04/16.
 */
public class Querys {

    public static String TAG = "BASE DE DATOS";

    public static String CREAR_TABLA_CLIENTE = "CREATE TABLE Cliente (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, ApellidoPaterno TEXT, ApellidoMaterno TEXT, Sexo TEXT, FechaNacimiento TEXT, Telefono TEXT, Observaciones TEXT)";
    public static String CREAR_TABLA_CITA = "CREATE TABLE Cita (Id INTEGER PRIMARY KEY AUTOINCREMENT, Fecha Date, IdCliente INTEGER, TipoCita TEXT ,EstatusCita TEXT, Costo DECIMAL, Hora TIME, Servicio INTEGER)";
    public static String CREAR_TABLA_SERVICIO = "CREATE TABLE Servicio (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Costo DECIMALc, Duracion INTEGER, Observaciones TEXT)";

    public static String OBTENER_CLIENTES = "SELECT * FROM Cliente";
    public static String OBTENER_CITAS_PROXIMAS = "SELECT * FROM Cita";
    public static String OBTENER_SERVICIOS = "SELECT * FROM Servicio";

    public static void crearTablas(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREAR_TABLA_CITA);
        sqLiteDatabase.execSQL(CREAR_TABLA_CLIENTE);
        sqLiteDatabase.execSQL(CREAR_TABLA_SERVICIO);
    }


}
