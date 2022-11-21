package com.example.usuario.usuario.Empleados;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;

public class BorrarEmpleadoController {

    @FXML
    private Text CrearNuevoEmpleado;

    @FXML
    private Button borrar;



    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button creados_button;


    @FXML
    private Button crearNuevo_button;

    @FXML
    private ImageView foto;

    @FXML
    private Label label;

    @FXML
    private Text pasaporte1;

    @FXML
    private Text titulo;

    @FXML
    private TextField txt_pasaporte1;

    public String getMail_() {
        return mail_;
    }

    public void setMail_(String mail_) {
        this.mail_ = mail_;
    }

    public String mail_;
    @FXML
    private Button administracion;

    @FXML
    private Button borrar_button;
    @FXML
    void AdministracionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("com/example/usuario/usuario/Empleados/Administracion-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BorrarEmpleadoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/BorrarEmpleado-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BorrarClickedButton(ActionEvent event) {
        Empleado empleado = new Empleado();
        HttpResponse apiResponse = Unirest.delete("http://localhost:8080/api/v1/gimnasio/empleado/"+txt_pasaporte1.getText())
                .header("accept","application/json" )
                .header("Content-Type", "application/json")
                .body(empleado).asEmpty();
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
    void CrearNuevoClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/CrearEmpleado-view.fxml"));
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
        Stage stage;
        Scene scene;
        Parent root = fxmlLoader.load(EmpleadosCreadosController.class.getResourceAsStream("/com/example/usuario/usuario/Empleados/EmpleadosCreados-view.fxml"));
        EmpleadosCreadosController empleadosCreadosController = fxmlLoader.getController();
        empleadosCreadosController.setMail(mail_);
        empleadosCreadosController.informacion();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
