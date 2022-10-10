package com.example.usuario.usuario;

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
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class TablaCentroDeportivoController implements Initializable {
    private Scene scene;
    private Stage stage;

    TableView<String> tableView;

    private TableColumn<String,String> rut;

    private TableColumn<String,Long> telefono;

    private TableColumn<String,String> direccion;
    private TableColumn<String,String> nombre;

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
        listarCentroDeportivo();
    }


    public void listarCentroDeportivo(){
        GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo")
                .header("Content-Type", "application/json");
        JsonNode temp = apiResponse.asJson().getBody();
        String tmp2=temp.toString();
        try {
            ObservableList<String> list = FXCollections.observableArrayList(tmp2);
            tableView = new TableView<>();
            tableView.setItems(list);
            list.add(tmp2);
            //rut.setCellValueFactory(new PropertyValueFactory<>("Rut"));
            //telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            //direccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
            //nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            System.out.println("HOLAA");
            System.out.println(rut);
            tableView.getColumns().addAll(rut, nombre);

        }catch (Exception ignored){}
    }

}

