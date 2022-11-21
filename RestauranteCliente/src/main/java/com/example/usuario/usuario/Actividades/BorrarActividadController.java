package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.LogInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrarActividadController {

    @FXML
    private Text CrearNuevaActividad;

    @FXML
    private Button administracion;

    @FXML
    private Button borrar;

    @FXML
    private Text rut;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button checkin_button;

    @FXML
    private Button creados_button;

    @FXML
    private Button crearNueva_button;

    @FXML
    private Label label;

    @FXML
    private Label label_yacreado;

    @FXML
    private Text nombre;

    @FXML
    private Text titulo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_rut;

    public String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    @FXML
    private Button borrar_button;

    @FXML
    void BorrarActividadClickedButton(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(CrearActividadController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/BorrarActividad-view.fxml"));
        BorrarActividadController borrarActividadController = fxmlLoader.getController();
        borrarActividadController.setMail(mail);


        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void AdministracionClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(AdministracionController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/Administracion-view.fxml"));
        AdministracionController administracionController= fxmlLoader.getController();
        administracionController.setMail(mail);
        administracionController.informacion();

        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/CrearActividad-view.fxml"));
        CrearActividadController controller = fxmlLoader.getController();
        controller.setMail(mail);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void BorrarClickedButton(ActionEvent event) {

    }


    public void CheckInClickedButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(CrearActividadController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/CheckIn-view.fxml"));
        CheckInController checkInController = fxmlLoader.getController();
        checkInController.setMail(mail);
        checkInController.info();
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(ActividadesCreadasController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/ActividadesCreadas-view.fxml"));
        ActividadesCreadasController actividadesCreadasController = fxmlLoader.getController();
        actividadesCreadasController.setMail(mail);
        actividadesCreadasController.inf();
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
