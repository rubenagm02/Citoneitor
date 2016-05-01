package com.citoneitor.Modelos;

/**
 * Created by ruben on 29/03/16.
 */
public class Servicio {

    private int id;
    private String nombre;
    private double costo;
    private double duracion; //La duración sera en minutos
    private String observaciones;

    public Servicio(int id, String nombre, double costo, double duracion, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.duracion = duracion;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
