package com.example.usuario.usuario.Empresas;

public class Empresa {

    private Long rut;

    private String nombre;

    private String mail;

    private String contra;

    private String tipo;
    public Empresa() {
    }

    public Empresa(Long rut, String nombre, String mail, String contra, String tipo) {
        this.rut = rut;
        this.nombre = nombre;
        this.mail = mail;
        this.contra = contra;
        this.tipo = tipo;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "rut=" + rut +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", contra='" + contra + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
