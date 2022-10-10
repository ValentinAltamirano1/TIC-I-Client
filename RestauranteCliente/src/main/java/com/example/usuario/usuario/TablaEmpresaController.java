package com.example.usuario.usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TablaEmpresaController implements Initializable {
    private Stage stage;
    private Scene scene;

    CentroDeportivoController centroDeportivo;

    @FXML
    private Button Volver_button;

    @FXML
    private TableView<?> tabla_empresa;

    @FXML
    private Label titulo;

    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarEmpresa();
    }

    public void listarEmpresa(){
        GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/empresa")
                .header("Content-Type", "application/json");
        JsonNode temp = apiResponse.asJson().getBody();

    }
}
