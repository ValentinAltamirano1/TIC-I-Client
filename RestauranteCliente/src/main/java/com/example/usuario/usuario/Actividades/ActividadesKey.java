package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;

public class ActividadesKey  {
    private CentroDeportivo centrosDeportivos;
    private String nombre;
    private String horario;

    public ActividadesKey() {
    }

    public ActividadesKey(CentroDeportivo centrosDeportivos, String nombre, String horario) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;
        this.horario = horario;

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


    @Override
    public String toString() {
        return "ActividadesKey{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'';


    }
}