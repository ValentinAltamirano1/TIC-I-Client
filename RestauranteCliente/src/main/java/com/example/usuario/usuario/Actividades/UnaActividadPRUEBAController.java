package com.example.usuario.usuario.Actividades;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class UnaActividadPRUEBAController implements Initializable {
    @FXML
    private Label capacidad;

    @FXML
    private Label horario;
    @FXML
    private Label nombre;

    @FXML
    private Label precio;

    @FXML
    private ImageView imagen_actividad;


    private Actividades actividad;

    public void setData(Actividades actividad){
        this.actividad = actividad;
        nombre.setText(actividad.getNombre());
        capacidad.setText(String.valueOf(actividad.getCapacidad()));
        precio.setText(String.valueOf(actividad.getPrecio()));
        horario.setText(actividad.getHorario());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

