package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

import java.util.Arrays;

public class Imagen {
    private Long id;

    private String nombre;

    private String tipo;

    private byte[] imageData;

    public Imagen(String nombre, String tipo, byte[] imageData) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imageData = imageData;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
}