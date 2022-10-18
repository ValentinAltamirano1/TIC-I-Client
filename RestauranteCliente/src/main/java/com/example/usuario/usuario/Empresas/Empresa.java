package com.example.usuario.usuario.Empresas;

public class Empresa {

    private Long rut;

    private String nombre;

    public Empresa() {
    }

    public Empresa(String nombre, Long rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}

    @Override
    public String toString() {
        return "Empresa{" +
                "rut=" + rut +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
