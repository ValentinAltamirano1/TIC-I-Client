package com.example.usuario.usuario.Empresas;

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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class EmpresaController implements Initializable {
    ObservableList<String> txt_list_tipos= FXCollections.
            observableArrayList("adminEmpresa");
    private Stage stage;
    private Scene scene;

    String nombre_;
    Long rut_;

    String mailAdmin_;

    String contraseñaAdmin_;

    String tipoAdmin_;
    @FXML
    private Text CrearNuevaEmpresa;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button creados_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;

    @FXML
    private Text nombre;

    @FXML
    private Text rut;

    @FXML
    private Text mail;

    @FXML
    private Text contrasena;

    @FXML
    private Text tipo;

    @FXML
    private Text titulo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_rut;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_contrasena;

    @FXML
    private ChoiceBox txt_tipo;

    @FXML
    private Button volver_button;

    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
        if(!txt_nombre.getText().isEmpty() && !txt_rut.getText().isEmpty() && !txt_mail.getText().isEmpty() && !txt_contrasena.getText().isEmpty()){
            try {
                nombre_ = txt_nombre.getText();
                rut_ = Long.parseLong(txt_rut.getText());
                mailAdmin_ = txt_mail.getText();
                contraseñaAdmin_= txt_contrasena.getText();
                tipoAdmin_ = txt_tipo.getValue().toString();
                String json = "";
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode rest = mapper.createObjectNode();
                    rest.put("nombre", nombre_);
                    rest.put("rut", rut_);
                    rest.put("mailAdmin", mailAdmin_);
                    rest.put("contraseñaAdmin",contraseñaAdmin_);
                    rest.put("tipoAdmin", tipoAdmin_);
                    json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
                }catch (Exception ignored) {
                }
                try {
                    HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/empresa")
                            .header("Content-Type", "application/json").body(json).asJson();
                }catch (UnirestException ex) {}
            }catch (NumberFormatException e){}
            //Empresa nuevaEmpresa = new Empresa(nombre, rut);
            //empresa.addNewEmpresa(nuevaEmpresa);
        }else{
            System.out.println("Ingrese correctamente todos los datos para guardar una nueva Empresa");
        }
    }
    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empresas/TablaEmpresa-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_tipo.setItems(txt_list_tipos);
        txt_tipo.setValue("Tipo");
    }
}

