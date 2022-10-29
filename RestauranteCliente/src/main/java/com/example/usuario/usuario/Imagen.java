package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;

import java.util.Arrays;

public class Imagen {

    private Actividades actividades;

    private byte[] imageData;

    public Imagen(Actividades actividades, byte[] imageData) {
        this.actividades = actividades;
        this.imageData = imageData;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
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
                "actividades=" + actividades +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
}