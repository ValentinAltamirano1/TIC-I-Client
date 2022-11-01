package com.example.usuario.usuario.CentrosDeportivos;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CentroDeportivoController implements Initializable {
    ObservableList<String> txt_tipo_list= FXCollections.
            observableArrayList("adminCentro");
    private Stage stage;
    private Scene scene;

    String nombre_;
    Long rut_;
    Long telefono_;
    String direccion_;

    String mailAdmin_;

    String contraseñaAdmin_;

    String tipoAdmin_;

    @FXML
    private Text CrearNuevoCentro;

    @FXML
    private Label label;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private ImageView foto;

    @FXML
    private Button volver_button;

    @FXML
    private Button crearNuevo_button;

    @FXML
    private Button checkin_button;
    @FXML
    private Text direccion;

    @FXML
    private Text nombre;
    @FXML
    private Text contrasena;
    @FXML
    private Text tipo;
    @FXML
    private Text mail;
    @FXML
    private Text rut;

    @FXML
    private Text telefono;

    @FXML
    private Text titulo;

    @FXML
    private Text titulo1;

    @FXML
    private TextField txt_direccion;

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_rut;

    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_contrasena;

    @FXML
    private ChoiceBox txt_tipo;

    @FXML
    private Button creados_button;


    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CrearClickedButton(ActionEvent event) {
        if (!txt_nombre.getText().isEmpty() && !txt_rut.getText().isEmpty() && !txt_telefono.getText().isEmpty() && !txt_direccion.getText().isEmpty() && !txt_mail.getText().isEmpty()
                && !txt_contrasena.getText().isEmpty()) {
            rut_ = Long.valueOf(txt_rut.getText());
            telefono_ = Long.valueOf(txt_telefono.getText());
            CentroDeportivo centroDeportivo = new CentroDeportivo(rut_, telefono_, txt_nombre.getText(), txt_direccion.getText(), txt_mail.getText(), txt_contrasena.getText(), txt_tipo.getValue().toString());
            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/centroDeportivo")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(centroDeportivo).asEmpty();

            label.setText("CENTRO CREADO CORRECTAMENTE!");
            txt_contrasena.setText("");
            txt_mail.setText("");
            txt_rut.setText("");
            txt_nombre.setText("");
            txt_direccion.setText("");
            txt_telefono.setText("");

        }else {
                System.out.println("Ingrese correctamente todos los datos para guardar un nuevo Centro Deportivo");
            }
        }
    @FXML
    void CrearNuevoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CentroDeportivo-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CheckIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/TablaCentrosDeportivos-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrarSesionClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_tipo.setItems(txt_tipo_list);
        txt_tipo.setValue("Tipo");
    }
}
