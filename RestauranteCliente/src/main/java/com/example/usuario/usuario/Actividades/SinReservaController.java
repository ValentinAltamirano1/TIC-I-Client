package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.HorarioKey;
import com.example.usuario.usuario.Reservas;
import com.example.usuario.usuario.ReservasKey;
import com.example.usuario.usuario.Usuario.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class SinReservaController implements Initializable {

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
    private TextField txt_horario;
    @FXML
    private TextField txt_pasaporte;

    public String diaSemana;

    public String mail;

    public Actividades actividad_;

    @FXML
    private Button borrar_button;

    @FXML
    void BorrarActividadClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/BorrarActividad-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividad-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CheckIn-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/TablaActividades-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrarSesionClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        Stage stage;
        Scene scene;
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
        //Agarro empleado
        GetRequest response = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/pasaporte/"+txt_pasaporte.getText())
                .header("Content-Type", "application/json");
        String temp = response.asJson().getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        List<Empleado> empleados =null;
        try {
            empleados = mapper.readValue(temp, new TypeReference<List<Empleado>>() {});
            System.out.println(empleados.get(0));
        } catch (JsonProcessingException e) {}


        //agarro actividades del centro con el nombre ingresado
        GetRequest response2 = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades/centro/" + mail + "/" + txt_actividad.getText())
                .header("Content-Type", "application/json");
        String temp2 = response2.asJson().getBody().toString();
        ObjectMapper mapper1 = new ObjectMapper();
        List<Actividades> actividades =null;
        try {
            actividades = mapper1.readValue(temp2, new TypeReference<List<Actividades>>() {});
            actividad_ = actividades.get(0);
            System.out.println(actividades.get(0));
        } catch (JsonProcessingException e) {}


        ReservasKey reservasKey = new ReservasKey(empleados.get(0),txt_fecha.getValue().toString(),txt_horario.getText());
        Reservas reservas1 = new Reservas(actividad_,reservasKey,true,"reservado");

        HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/reservas")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(reservas1).asEmpty();

        Actividades actividades2 = new Actividades(actividad_.getActividadesKey(),actividad_.getPrecio(),actividad_.getCategoria(),actividad_.getCapacidad(),actividad_.getDescripcion(),actividad_.getCupos(),actividad_.getHorarios(),actividad_.getImagen());
        HttpResponse apiResponse1 =  Unirest.post("http://localhost:8080/api/v1/gimnasio/actividades/update")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(actividades2).asEmpty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

