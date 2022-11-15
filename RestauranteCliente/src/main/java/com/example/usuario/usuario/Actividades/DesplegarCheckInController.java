package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empleados.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DesplegarCheckInController {

    @FXML
    private Label capacidad2;

    @FXML
    private Button confirmar_button;

    @FXML
    private Label nombre2;

    @FXML
    private Label pasaporte2;

    @FXML
    private Label precio2;

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
        System.out.println(this.actividades1);
    }

    public void setData1(Actividades actividades){
        this.actividades1 = actividades;

        nombre2.setText(actividades.getActividadesKey().getNombre());
        precio2.setText(String.valueOf(actividades.getPrecio()));
        capacidad2.setText(String.valueOf(actividades.getCapacidad()));
        //pasaporte2.setText(empleados.getPasaporte());

    }
}

