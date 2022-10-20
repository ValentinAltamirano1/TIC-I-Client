package com.example.usuario.usuario.CentrosDeportivos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearAdminCentroDeportivoController implements Initializable {
    Scene scene;
    Stage stage;

    @FXML
    private Text CrearNuevaEmpresa;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Text contraseña;

    @FXML
    private Button creados_button;

    @FXML
    private Button crear_button;

    @FXML
    private Button crearcentro_button;

    @FXML
    private ImageView foto;

    @FXML
    private Text nombre;

    @FXML
    private Text titulo;

    @FXML
    private Text titulo1;

    @FXML
    private TextField txt_contraseña;

    @FXML
    private TextField txt_nombre;

    @FXML
    private Button volver_button;

    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/TablaCentroDeportivo-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearClickedButton(ActionEvent event) {

    }

    @FXML
    void CrearCentroDeportivoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CentroDeportivo-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
