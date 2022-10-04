package com.example.usuario.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private AnchorPane OkButton;

    @FXML
    private Button cancel_button;

    @FXML
    private Label contraseña;

    @FXML
    private Label nombre_de_usuario;

    @FXML
    private Button ok_button;

    @FXML
    private Label titulo_login;

    @FXML
    private TextField txt_contraseña;

    @FXML
    private TextField txt_email;


    @FXML
    void OkClickedButton(ActionEvent event) throws IOException {
        if (txt_email.getText().equals("admin") && txt_contraseña.getText().equals("admin")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones-view.fxml"));
            String json = "";
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode rest = mapper.createObjectNode();
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
            try {
                HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v3/gimnasio")
                        .header("Content-Type", "application/json").body(json).asJson();
            } catch (UnirestException ex) {
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void CancelClickedButton(ActionEvent event) {
        System.out.println("Ingrese correctamente todos los datos para acceder");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}




