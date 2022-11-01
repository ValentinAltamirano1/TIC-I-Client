package com.example.usuario.usuario.Empresas;

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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TablaEmpresasController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;
    @FXML
    private TableColumn<Empresa, String> nombre;

    @FXML
    private TableColumn<Empresa, String> rut;

    @FXML
    private TableColumn<Empresa, String> mail;

    @FXML
    private TableColumn<Empresa, String> contra;

    @FXML
    private TableColumn<Empresa, String> tipo;
    @FXML
    private Button crearNueva_button;

    @FXML
    private Button creadas_button;
    @FXML
    private TableView<Empresa> tableView;

    @FXML
    private Button volver_button;

    @FXML
    private ObservableList<Empresa> list;

    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CrearEmpresaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empresas/Empresa-view.fxml"));
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
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empresas/EmpresaController.java"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empresas/Empresa-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rut.setCellValueFactory(new PropertyValueFactory<Empresa,String>("rut"));
        nombre.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nombre"));
        mail.setCellValueFactory(new PropertyValueFactory<Empresa, String>("mail"));
        contra.setCellValueFactory(new PropertyValueFactory<Empresa, String>("contra"));
        tipo.setCellValueFactory(new PropertyValueFactory<Empresa, String>("tipo"));
        listarEmpresa();
    }

    public void listarEmpresa(){
        List<Empresa> empresas=null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/empresa")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();

            ObjectMapper mapper = new ObjectMapper();
            System.out.println(temp);
            empresas = mapper.readValue(temp, new TypeReference<List<Empresa>>(){});
            System.out.println("HOLA");
            System.out.println(empresas);
            list = FXCollections.observableArrayList(empresas);

            tableView.setItems(list);

        }catch (Exception ignored){}


    }
}
