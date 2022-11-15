package com.example.usuario.usuario.CentrosDeportivos;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Usuario.MyListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DesplegarCentrosController {

    @FXML
    private Label contrasena;

    @FXML
    private Label direccion;

    @FXML
    private Label mail;

    @FXML
    private Label nombre;

    @FXML
    private Label rut;

    @FXML
    private Label telefono;

    @FXML
    private Label tipo;

    private CentroDeportivo centros;

    public void setData(CentroDeportivo centros){
        this.centros = centros;
        nombre.setText(centros.getNombre());
        rut.setText(String.valueOf(centros.getRut()));
        direccion.setText(centros.getDireccion());
        telefono.setText(String.valueOf(centros.getTelefono()));
        mail.setText(centros.getMail());
        contrasena.setText(centros.getContra());
        tipo.setText(centros.getTipo());
    }

}