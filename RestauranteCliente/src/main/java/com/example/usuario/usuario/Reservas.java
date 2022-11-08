package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

public class Reservas {

    private Actividades actividades;


    private ReservasKey reservasKey;

    private boolean asistio;

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Reservas() {
    }

    public Reservas(Actividades actividades, ReservasKey reservasKey, boolean asistio) {
        this.actividades = actividades;
        this.reservasKey = reservasKey;
        this.asistio = asistio;
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

    @Override
    public String toString() {
        return "Reservas{" +
                "actividades=" + actividades +
                ", reservasKey=" + reservasKey +
                ", asistio=" + asistio +
                '}';
    }
}
