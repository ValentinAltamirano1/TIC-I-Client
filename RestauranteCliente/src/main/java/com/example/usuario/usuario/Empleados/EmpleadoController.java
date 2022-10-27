package com.example.usuario.usuario.Empleados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
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
            try {
                nombre_ = txt_nombre.getText();
                mail_ = txt_mail.getText();
                pasaporte_ = txt_pasaporte.getText();
                telefono_ = Integer.parseInt(txt_telefono.getText());
                contraseña_= txt_contraseña.getText();
                fichaMedica_ = txt_fichamedica.getValue();
                tipo_ = txt_tipo.getValue();
                String json = "";
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode rest = mapper.createObjectNode();
                    rest.put("pasaporte", pasaporte_);
                    rest.put("nombre", nombre_);
                    rest.put("telefono",telefono_);
                    rest.put("mail",mail_ );
                    rest.put("contraseña", contraseña_);
                    rest.put("ficha_medica", String.valueOf(fichaMedica_));
                    rest.put("tipo",tipo_ );
                    json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
                }catch (Exception ignored) {
                }
                try {
                    HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/empleado")
                            .header("Content-Type", "application/json").body(json).asJson();

                    label.setText("EMPLEADO CREADO CORRECTAMENTE!");
                    txt_pasaporte.setText("");
                    txt_nombre.setText("");
                    txt_telefono.setText("");
                    txt_mail.setText("");
                    txt_contraseña.setText("");

                }catch (UnirestException ex) {}
            }catch (NumberFormatException e){}
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
