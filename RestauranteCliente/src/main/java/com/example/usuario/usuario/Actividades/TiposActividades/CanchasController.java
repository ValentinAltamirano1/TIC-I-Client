package com.example.usuario.usuario.Actividades.TiposActividades;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CanchasController implements Initializable {
     Scene scene;
     Stage stage;
    @FXML
    private Label capacidad1;

    @FXML
    private Label capacidad2;

    @FXML
    private Label capacidad3;

    @FXML
    private Label horario1;

    @FXML
    private Label horario2;

    @FXML
    private Label horario3;

    @FXML
    private Label nombre1;

    @FXML
    private Label nombre2;

    @FXML
    private Label nombre3;

    @FXML
    private Label precio1;

    @FXML
    private Label precio2;

    @FXML
    private Label precio3;
    @FXML
    private Button canchas_button;
    @FXML
    private Button siguiente_button;
    @FXML
    private Button volver_button;

    @FXML
    void VolverButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Actividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void SiguienteButtonClicked(ActionEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
