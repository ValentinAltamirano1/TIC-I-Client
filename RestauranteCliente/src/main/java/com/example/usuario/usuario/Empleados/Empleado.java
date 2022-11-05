package com.example.usuario.usuario.Empleados;

import com.example.usuario.usuario.Empresas.Empresa;

import java.time.LocalDate;

public class Empleado {
    private String pasaporte;
    private String nombre;
    private int telefono;

    private String mail;

    private String contraseña;

    private String ficha_medica;
    private String tipo;

    private int saldo;

    private int sobre_giro;//adicional por lo que el empleado se va a poder pasar de plata

    private Empresa empresas;

    public Empleado() {
    }


    public Empleado(String pasaporte, String nombre, int telefono, String mail, String contraseña, String ficha_medica, String tipo, int saldo, int sobre_giro, Empresa empresas) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.contraseña = contraseña;
        this.ficha_medica = ficha_medica;
        this.tipo = tipo;
        this.saldo = saldo;
        this.sobre_giro = sobre_giro;
        this.empresas = empresas;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSobre_giro() {
        return sobre_giro;
    }

    public void setSobre_giro(int sobre_giro) {
        this.sobre_giro = sobre_giro;
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

    public String getFicha_medica() {
        return ficha_medica;
    }

    public void setFicha_medica(String ficha_medica) {
        this.ficha_medica = ficha_medica;
    }

    public Empresa getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresa empresas) {
        this.empresas = empresas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", ficha_medica='" + ficha_medica + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo='" + saldo + '\'' +
                ", sobre_giro='" + sobre_giro + '\'' +
                ", empresas=" + empresas +
                '}';
    }
}
