package com.example.usuario.usuario;

public class CentroDeportivo {
    private Long rut;
    private Long telefono;
    private String nombre;
    private String direccion;

    public CentroDeportivo(Long telefono, String nombre, String direccion, Long rut) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rut = rut;
    }
    public CentroDeportivo() {

    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}

    @Override
    public String toString() {
        return "CentroDeportivo{" +
                "rut=" + rut +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
