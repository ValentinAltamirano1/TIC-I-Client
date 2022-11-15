package com.example.usuario.usuario.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BuscarController implements Initializable {

    @FXML
    private Button actividades;

    @FXML
    private Button buscar;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private ChoiceBox<?> choicebox;

    @FXML
    private Label cupos;

    @FXML
    private Label cupos_grande;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Label descripcion;

    @FXML
    private Label descripcion_grande;

    @FXML
    private ImageView foto_logo;

    @FXML
    private GridPane grid;

    @FXML
    private HBox nombre;

    @FXML
    private Label nombre_grande;

    @FXML
    private Label precio;

    @FXML
    private Label precio_grande;

    @FXML
    private Button reservar_button;

    @FXML
    private Button reservas;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label titulo;

    @FXML
    private Label usuario_nombre;

    @FXML
    private Label usuario_nombre1;

    @FXML
    void ActividadesClickedButton(ActionEvent event) {

    }

    @FXML
    void BuscarClickedButton(ActionEvent event) {

    }

    @FXML
    void CerrrSesionClickedButton(ActionEvent event) {

    }

    @FXML
    void MisReservasClickedButton(ActionEvent event) {

    }

    @FXML
    void ReservarClickedButton(ActionEvent event) {

    }

    @FXML
    void getDate(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
