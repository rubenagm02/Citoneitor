package com.citoneitor.Modelos;

/**
 * Created by ruben on 23/03/16.
 */
public class Cita {
    private int id;
    private String fecha;
    private int idCliente;
    private int tipoCita;
    private String idEstatusCita;
    private double costo;
    private String hora;
    private int servicio;

    public Cita(int id, String fecha, int idCliente, int tipoCita, String idEstatusCita, double costo, String hora, int servicio) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.tipoCita = tipoCita;
        this.idEstatusCita = idEstatusCita;
        this.costo = costo;
        this.hora = hora;
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(int tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getIdEstatusCita() {
        return idEstatusCita;
    }

    public void setIdEstatusCita(String idEstatusCita) {
        this.idEstatusCita = idEstatusCita;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
}
