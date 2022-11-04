package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

import java.util.Arrays;

public class Imagen {
    private String nombre;

    public Imagen(){
    }
    public Imagen(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}