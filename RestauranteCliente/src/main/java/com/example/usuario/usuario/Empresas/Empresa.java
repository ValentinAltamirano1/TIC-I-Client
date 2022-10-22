package com.example.usuario.usuario.Empresas;

public class Empresa {

    private Long rut;

    private String nombre;

    private String mailAdmin;

    private String contraseñaAdmin;

    private String tipoAdmin;
    public Empresa() {
    }

    public Empresa(Long rut, String nombre, String mailAdmin, String contraseñaAdmin, String tipoAdmin) {
        this.rut = rut;
        this.nombre = nombre;
        this.mailAdmin = mailAdmin;
        this.contraseñaAdmin = contraseñaAdmin;
        this.tipoAdmin = tipoAdmin;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}


    @Override
    public String toString() {
        return "Empresa{" +
                "rut=" + rut +
                ", nombre='" + nombre + '\'' +
                ", mailAdmin='" + mailAdmin + '\'' +
                ", contraseñaAdmin='" + contraseñaAdmin + '\'' +
                ", tipoAdmin='" + tipoAdmin + '\'' +
                '}';
    }
}
