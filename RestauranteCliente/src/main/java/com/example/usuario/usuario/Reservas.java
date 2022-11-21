package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

public class Reservas {

    private Actividades actividades;


    private ReservasKey reservasKey;

    private boolean asistio;

    private String estado;

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Reservas() {
    }

    public Reservas(Actividades actividades, ReservasKey reservasKey, boolean asistio, String estado) {
        this.actividades = actividades;
        this.reservasKey = reservasKey;
        this.asistio = asistio;
        this.estado = estado;
    }

    public ReservasKey getReservasKey() {
        return reservasKey;
    }

    public void setReservasKey(ReservasKey reservasKey) {
        this.reservasKey = reservasKey;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "actividades=" + actividades +
                ", reservasKey=" + reservasKey +
                ", asistio=" + asistio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
