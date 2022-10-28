package com.example.usuario.usuario.Actividades;

public class Actividades {
    private String nombre;
    private String horario;
    private int precio;
    private String categoria;
    private int capacidad;

    private int cupos;

    private String descripcion;

    public Actividades() {
    }

    public Actividades(String nombre, String horario, int precio, String categoria, int capacidad, int cupos, String descripcion) {
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.cupos = cupos;
        this.descripcion = descripcion;
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

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", cupos=" + cupos +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
