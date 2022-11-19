package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.Usuario.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SinReservaController implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private Label actividad;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button checkin_button;

    @FXML
    private Button administracion;


    @FXML
    private Text confirmar;

    @FXML
    private Text confirmar1;

    @FXML
    private Button creados_button;

    @FXML
    private Button crearNueva_button;

    @FXML
    private Button darCheckIn;

    @FXML
    private AnchorPane darcheckin;

    @FXML
    private ImageView foto;

    @FXML
    private Label label_checkin;

    @FXML
    private Label pasaporte;

    @FXML
    private Text titulo;

    @FXML
    private TextField txt_actividad;

    @FXML
    private DatePicker txt_fecha;
    @FXML
    private ChoiceBox txt_horario;
    @FXML
    private TextField txt_pasaporte;


    @FXML
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividad-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CheckIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/TablaActividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrarSesionClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void AdministracionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Administracion-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void DarCheckInClickedButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();
        Usuarios u = (Usuarios) stage1.getUserData();
        System.out.println(u.getMail());

        //Agarro empleado
        GetRequest response = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/"+txt_pasaporte.getText())
                .header("Content-Type", "application/json");
        String temp = response.asJson().getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        List<Empleado> empleados =null;
        try {
            empleados = mapper.readValue(temp, new TypeReference<List<Empleado>>() {});
            System.out.println(empleados.get(0));
        } catch (JsonProcessingException e) {}


        //agarro actividades
        GetRequest response2 = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades/" + u.getMail())
                .header("Content-Type", "application/json");
        String temp2 = response.asJson().getBody().toString();
        ObjectMapper mapper1 = new ObjectMapper();
        List<Actividades> actividades =null;
        try {
            actividades = mapper.readValue(temp, new TypeReference<List<Actividades>>() {});
            System.out.println(actividades.get(0));

        } catch (JsonProcessingException e) {}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
