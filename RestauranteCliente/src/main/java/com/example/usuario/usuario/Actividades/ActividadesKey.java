package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;

public class ActividadesKey  {
    private CentroDeportivo centrosDeportivos;
    private String nombre;


    public ActividadesKey() {
    }

    public ActividadesKey(CentroDeportivo centrosDeportivos, String nombre) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;

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


    @Override
    public String toString() {
        return "ActividadesKey{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'';

    }
}