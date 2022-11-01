package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DesplegarController {

    @FXML
    private Label capacidad1;

    @FXML
    private Label horario1;

    @FXML
    private Label nombre1;

    @FXML
    private Label precio1;

    @FXML
    private Button reserva_button;

    @FXML
    private Label titulo_capacidad;

    @FXML
    private Label titulo_horario;

    @FXML
    private Label titulo_nombre;

    @FXML
    private Label titulo_precio;

    @FXML
    void ReservarClickedButton(ActionEvent event) {

    }
    private Actividades actividades;

    public void setData(Actividades actividades){
        /*this.actividades = actividades;
        nombre1.setText(actividades.getNombre());
        precio1.setText(String.valueOf(actividades.getPrecio()));
        horario1.setText(actividades.getHorario());
        capacidad1.setText(String.valueOf(actividades.getCapacidad()));*/
    }

}

