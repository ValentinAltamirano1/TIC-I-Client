package com.example.usuario.usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CrearActividadesController {

    @FXML
    private Text actividades_titulo;

    @FXML
    private Text capacidad;

    @FXML
    private Text categoria;

    @FXML
    private Text horario;

    @FXML
    private Text nombre;

    @FXML
    private Text precio;

    @FXML
    private TextField txt_capacidad;

    @FXML
    private DatePicker txt_horario;

    @FXML
    private TextField txt_nombre;

    @FXML
    private ChoiceBox<?> txt_opcion;

    @FXML
    private TextField txt_precio;

    @FXML
    private Button volver_button;

    @FXML
    void volverClickedButton(ActionEvent event) {


    }

}
