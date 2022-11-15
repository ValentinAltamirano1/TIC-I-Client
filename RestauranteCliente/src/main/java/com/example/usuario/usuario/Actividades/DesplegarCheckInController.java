package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empleados.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DesplegarCheckInController {

    @FXML
    private Label capacidad;

    @FXML
    private Button confirmar_button;

    @FXML
    private Label nombre;

    @FXML
    private Label pasaporte;

    @FXML
    private Label precio;

    @FXML
    private Label titulo_capacidad;

    @FXML
    private Label titulo_horario;

    @FXML
    private Label titulo_nombre;

    @FXML
    private Label titulo_pasaporte;

    @FXML
    private Label titulo_precio;

    private Actividades actividades1;
    private Empleado empleados;
    @FXML
    void ConfirmarClickedButton(ActionEvent event) {


    }

    public void setData1(Actividades actividades){
        this.actividades1 = actividades;
        nombre.setText(actividades.getActividadesKey().getNombre());
        precio.setText(String.valueOf(actividades.getPrecio()));
        capacidad.setText(String.valueOf(actividades.getCapacidad()));
        pasaporte.setText(empleados.getPasaporte());

    }
}

