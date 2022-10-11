package com.example.usuario.usuario;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class TablaCentroDeportivoController implements Initializable {
    private Scene scene;
    private Stage stage;

    TableView<CentroDeportivo> tableView;

    private TableColumn<CentroDeportivo,String> rut;

    private TableColumn<CentroDeportivo,Long> telefono;

    private TableColumn<CentroDeportivo,String> direccion;
    private TableColumn<CentroDeportivo,String> nombre;

    private ObservableList<CentroDeportivo> list;
    @FXML
    private Label titulo;

    @FXML
    private Button Volver_cancelar;

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
        try {
            rut.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("Rut"));
            telefono.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, Long>("Telefono"));
            direccion.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("Direccion"));
            nombre.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("Nombre"));
        }catch (Exception ignored){}
        listarCentroDeportivo();
    }


    public void listarCentroDeportivo(){
        String json = "";
        ObservableList<CentroDeportivo> lista=null;
        try {
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();

            ObjectMapper mapper = new ObjectMapper();
            lista = mapper.readValue(temp, new TypeReference<ObservableList<CentroDeportivo>>() {});
            list = FXCollections.observableArrayList(lista);


            tableView = new TableView<>();
            tableView.setItems(list);
            //tableView.getColumns().addAll(list);

        }catch (Exception ignored){}
    }

}

