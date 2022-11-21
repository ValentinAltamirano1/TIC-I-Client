package com.example.usuario.usuario.CentrosDeportivos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrarCentroDeportivoController {

    @FXML
    private Text CrearNuevoCentro;

    @FXML
    private Button borrar;

    @FXML
    private Button cerrar_sesion_button1;

    @FXML
    private Button creados_button1;

    @FXML
    private Button crearNuevo_button1;

    @FXML
    private ImageView foto;

    @FXML
    private Label label_yacreado;

    @FXML
    private Text rut;

    @FXML
    private Label titulo_dos;

    @FXML
    private Label titulo_uno;

    @FXML
    private TextField txt_rut;

    @FXML
    private Button volver_button;

    @FXML
    private Button borrar_button;
    @FXML
    void BorrarCentroClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/BorrarCentroDeportivo-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BorrarClickedButton(ActionEvent event) {

    }


    @FXML
    void CrearNuevoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CrearCentroDeportivo-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CentrosDeportivosCreados-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrarSesionClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
