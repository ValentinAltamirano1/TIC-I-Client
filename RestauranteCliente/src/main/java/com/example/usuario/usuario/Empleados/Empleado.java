package com.example.usuario.usuario.Empleados;

public class Empleado {
    private String pasaporte;
    private String nombre;
    private String mail;
    private int telefono;
    private String tipo;

    public Empleado() {
    }

    public Empleado(String pasaporte, String nombre, String mail, int telefono, String tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Empleados{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono=" + telefono +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
