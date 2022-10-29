package com.example.usuario.usuario.Empleados;

import com.example.usuario.usuario.Empresas.Empresa;
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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class EmpleadoController implements Initializable {
    ObservableList<String> txt_tipo_list= FXCollections.
            observableArrayList("Usuario");
    Stage stage;
    Scene scene;

    String nombre_;
    String pasaporte_;
    String mail_;
    int telefono_;
    String tipo_;

    String contraseña_;

    LocalDate fichaMedica_;
    @FXML
    private Text CrearNuevoEmpleado;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button creados_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;

    @FXML
    private Text mail;

    @FXML
    private Text nombre;

    @FXML
    private Text telefono;
    @FXML
    private Text pasaporte;
    @FXML
    private Text titulo;
    @FXML
    private Text tipo;
    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_pasaporte;
    @FXML
    private TextField txt_telefono;
    @FXML
    private TextField txt_contraseña;
    @FXML
    private DatePicker txt_fichamedica;
    @FXML
    private ChoiceBox<String> txt_tipo;

    @FXML
    private Label label;
    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/TablaEmpleados-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearClickedButton(ActionEvent event) {


        if(!txt_nombre.getText().isEmpty() && !txt_mail.getText().isEmpty() && !txt_pasaporte.getText().isEmpty() && !txt_telefono.getText().isEmpty() && !txt_contraseña.getText().isEmpty()){
            telefono_ = Integer.parseInt(txt_telefono.getText());

            Empleado empleado = new Empleado(txt_pasaporte.getText(), txt_nombre.getText(), telefono_, txt_mail.getText(), txt_contraseña.getText(), txt_fichamedica.getValue().toString(), txt_tipo.getValue());
            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/empleado")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(empleado).asEmpty();

            label.setText("EMPLEADO CREADO CORRECTAMENTE!");
            txt_pasaporte.setText("");
            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_mail.setText("");
            txt_contraseña.setText("");

        }else{
            System.out.println("Ingrese correctamente todos los datos para guardar una nueva Empresa");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_tipo.setItems(txt_tipo_list);
        txt_tipo.setValue("Tipo");
    }
}
