package com.example.usuario.usuario.Empresas;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Empresas.Empresa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DesplegarEmpresasController {

    @FXML
    private Label contrasena;

    @FXML
    private Label mail;

    @FXML
    private Label nombre;

    @FXML
    private Label rut;

    @FXML
    private Label tipo;

    private Empresa empresas;

    public void setData(Empresa empresas) {
        this.empresas = empresas;
        nombre.setText(empresas.getNombre());
        rut.setText(String.valueOf(empresas.getRut()));
        mail.setText(empresas.getMail());
        contrasena.setText(empresas.getContra());
        tipo.setText(empresas.getTipo());
    }
}
