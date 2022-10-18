package com.example.usuario.usuario;

public class Usuarios {
    private String mail;

    private String contraseña;


    private String tipoUsuario;

    public Usuarios() {
    }

    public Usuarios(String mail, String contraseña, String tipoUsuario) {
        this.mail = mail;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getContraseña() {return contraseña;}

    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    @Override
    public String toString() {
        return "Usuarios{" +
                "mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}