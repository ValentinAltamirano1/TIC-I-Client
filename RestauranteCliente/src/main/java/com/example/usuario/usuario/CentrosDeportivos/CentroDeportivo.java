package com.example.usuario.usuario.CentrosDeportivos;

public class CentroDeportivo {
    private Long rut;
    private Long telefono;
    private String nombre;
    private String direccion;
    private String mail;
    private String contra;
    private String tipo;


    public CentroDeportivo() {

    }

    public CentroDeportivo(Long rut, Long telefono, String nombre, String direccion, String mail, String contra, String tipo) {
        this.rut = rut;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.contra = contra;
        this.tipo = tipo;
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
        return "CentroDeportivo{" +
                "rut=" + rut +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", mail='" + mail + '\'' +
                ", contra='" + contra + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
