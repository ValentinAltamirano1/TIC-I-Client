package com.example.usuario.usuario.Empleados;

import java.time.LocalDate;

public class Empleado {
    private String pasaporte;
    private String nombre;
    private int telefono;

    private String mail;

    private String contraseña;

    private LocalDate fichaMedica;
    private String tipo;

    public Empleado() {
    }

    public Empleado(String pasaporte, String nombre, int telefono, String mail, String contraseña, LocalDate fichaMedica, String tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.contraseña = contraseña;
        this.fichaMedica = fichaMedica;
        this.tipo = tipo;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(LocalDate fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fichaMedica=" + fichaMedica +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
