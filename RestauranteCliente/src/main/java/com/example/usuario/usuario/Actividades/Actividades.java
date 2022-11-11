package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.HorarioKey;
import com.example.usuario.usuario.Imagen;
import javafx.fxml.FXML;

import java.util.List;

public class Actividades {

    private ActividadesKey actividadesKey;

    private int precio;

    private String categoria;

    private int capacidad;

    private String descripcion;

    private int cupos;
    private List <HorarioKey> horarios;
    private List<Imagen> imagen;


    public Actividades() {
    }



    public Actividades(ActividadesKey actividadesKey, int precio, String categoria, int capacidad, String descripcion, int cupos, List<HorarioKey> horarios, List<Imagen> imagen) {
        this.actividadesKey = actividadesKey;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.horarios = horarios;
        this.imagen = imagen;
    }

    public List<HorarioKey> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioKey> horarios) {
        this.horarios = horarios;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public List<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(List<Imagen> imagen) {
        this.imagen = imagen;
    }

    public ActividadesKey getActividadesKey() {
        return actividadesKey;
    }

    public void setActividadesKey(ActividadesKey actividadesKey) {
        this.actividadesKey = actividadesKey;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "actividadesKey=" + actividadesKey +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                ", cupos=" + cupos +
                ", horarios=" + horarios +
                ", imagen=" + imagen +
                '}';
    }
}
