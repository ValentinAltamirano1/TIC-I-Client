package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;

import java.io.Serializable;

public class ActividadesKey  {
    private CentroDeportivo centrosDeportivos;
    private String nombre;
    private String horario;
    private String fecha;
    public ActividadesKey() {
    }

    public ActividadesKey(CentroDeportivo centrosDeportivos, String nombre, String horario, String fecha) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;
        this.horario = horario;
        this.fecha = fecha;
    }

    public CentroDeportivo getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentroDeportivo centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ActividadesKey{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}