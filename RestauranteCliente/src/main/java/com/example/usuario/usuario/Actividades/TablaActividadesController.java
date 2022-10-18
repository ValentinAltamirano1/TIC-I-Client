package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empresas.Empresa;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TablaActividadesController implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private TableView<Actividades> tableView;
    @FXML
    private Text EmpresasCreadas;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;

    @FXML
    private TableColumn<Actividades, ?> nombre;

    @FXML
    private TableColumn<Actividades, ?> nombre1;

    @FXML
    private TableColumn<Actividades, ?> nombre2;

    @FXML
    private TableColumn<Actividades, ?> nombre21;

    @FXML
    private TableColumn<Actividades, ?> rut;

    @FXML
    private Text titulo1;

    @FXML
    private Button volver_button;
    @FXML
    private ObservableList<Actividades> list;
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
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void listarActividades(){
        List<Actividades> actividades=null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();

            ObjectMapper mapper = new ObjectMapper();

            actividades = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});

            list = FXCollections.observableArrayList(actividades);

            tableView.setItems(list);

        }catch (Exception ignored){}


    }
}
