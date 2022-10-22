package com.example.usuario.usuario.CentrosDeportivos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class TablaCentroDeportivoController implements Initializable {
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<CentroDeportivo> tableView;

    @FXML
    private TableColumn<CentroDeportivo,String> rut;

    @FXML
    private TableColumn<CentroDeportivo,String> mailAdmin;

    @FXML
    private TableColumn<CentroDeportivo,String> contraseñaAdmin;

    @FXML
    private TableColumn<CentroDeportivo,String> tipoAdmin;

    @FXML
    private TableColumn<CentroDeportivo,Long> telefono;

    @FXML
    private TableColumn<CentroDeportivo,String> direccion;

    @FXML
    private TableColumn<CentroDeportivo,String> nombre;

    @FXML
    private ObservableList<CentroDeportivo> list;

    @FXML
    private Text centroscreados;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;

    @FXML
    private Text titulo1;

    @FXML
    private Text titulo2;

    @FXML
    private Button volver_button;

    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CrearClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/CentrosDeportivos/CentroDeportivo-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rut.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("rut"));
        direccion.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("direccion"));
        nombre.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, String>("nombre"));
        telefono.setCellValueFactory(new PropertyValueFactory<CentroDeportivo, Long>("telefono"));
        mailAdmin.setCellValueFactory(new PropertyValueFactory<CentroDeportivo,String>("mailAdmin"));
        contraseñaAdmin.setCellValueFactory(new PropertyValueFactory<CentroDeportivo,String>("contraseñaAdmin"));
        tipoAdmin.setCellValueFactory(new PropertyValueFactory<CentroDeportivo,String>("tipoAdmin"));
        listarCentroDeportivo();
    }
    public void listarCentroDeportivo(){
        List<CentroDeportivo> centrosDepor;
        try {
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(temp);
            centrosDepor = mapper.readValue(temp, new TypeReference<List<CentroDeportivo>>() {});
            System.out.println(centrosDepor);
            list = FXCollections.observableArrayList(centrosDepor);
            System.out.println(list);
            tableView.setItems(list);

        }catch (Exception ignored){}
    }
}

