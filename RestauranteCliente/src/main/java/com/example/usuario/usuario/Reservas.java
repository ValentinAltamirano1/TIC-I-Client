package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

public class Reservas {

    private Actividades actividades;

    private ReservasKey reservasKey;

    public Reservas() {
    }

    public Reservas(Actividades actividades, ReservasKey reservasKey) {
        this.actividades = actividades;
        this.reservasKey = reservasKey;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public ReservasKey getReservasKey() {
        return reservasKey;
    }

    public void setReservasKey(ReservasKey reservasKey) {
        this.reservasKey = reservasKey;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "actividades=" + actividades +
                ", reservasKey=" + reservasKey +
                '}';
    }
}
