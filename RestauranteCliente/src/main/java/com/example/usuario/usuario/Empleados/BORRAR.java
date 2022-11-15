package com.example.usuario.usuario.Empleados;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BORRAR implements Initializable {
    Stage stage;
    Scene scene;

    @FXML
    private Text EmpleadosCreados;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button crear_button;

    @FXML
    private ImageView foto;

    @FXML
    private TableColumn<Empleado, String> mail;

    @FXML
    private TableColumn<Empleado, String> nombre;

    @FXML
    private TableColumn<Empleado, String> pasaporte;
    @FXML
    private TableColumn<Empleado, String> saldo;

    @FXML
    private TableColumn<Empleado, String> sobre_giro;

    @FXML
    private TableColumn<Empleado, String> telefono;

    @FXML
    private TableColumn<Empleado, String> contraseña;

    @FXML
    private TableColumn<Empleado, String> ficha_medica;

    @FXML
    private TableColumn<Empleado, String> tipo;
    @FXML
    private TableView<Empleado> tableView;
    @FXML
    private Text titulo;

    @FXML
    private Button volver_button;
    @FXML
    private Button crearNuevo_button;

    @FXML
    private Button creados_button;
    @FXML
    private ObservableList<Empleado> list;

    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearNuevoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/CrearEmpleado-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/TablaEmpleadosController.java"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void VolverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/CrearEmpleado-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mail.setCellValueFactory(new PropertyValueFactory<Empleado,String>("mail"));
        nombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        pasaporte.setCellValueFactory(new PropertyValueFactory<Empleado, String>("pasaporte"));
        telefono.setCellValueFactory(new PropertyValueFactory<Empleado,String>("telefono"));
        contraseña.setCellValueFactory(new PropertyValueFactory<Empleado,String>("contraseña"));
        ficha_medica.setCellValueFactory(new PropertyValueFactory<Empleado, String>("ficha_medica"));
        tipo.setCellValueFactory(new PropertyValueFactory<Empleado,String>("tipo"));
        saldo.setCellValueFactory(new PropertyValueFactory<Empleado,String>("saldo"));
        sobre_giro.setCellValueFactory(new PropertyValueFactory<Empleado,String>("sobre_giro"));
        listarEmpleados();
    }


    public void listarEmpleados(){
        List<Empleado> empleados;
        try {
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(temp);
            empleados = mapper.readValue(temp, new TypeReference<List<Empleado>>() {});
            System.out.println("HOLA");
            list = FXCollections.observableArrayList(empleados);
            System.out.println(list);
            tableView.setItems(list);

        } catch (Exception ignored) {}

    }
}
