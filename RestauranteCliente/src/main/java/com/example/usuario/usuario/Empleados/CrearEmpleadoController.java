package com.example.usuario.usuario.Empleados;

import com.example.usuario.usuario.Actividades.CheckInController;
import com.example.usuario.usuario.Actividades.CrearActividadController;
import com.example.usuario.usuario.Empresas.Empresa;
import com.example.usuario.usuario.Empresas.EmpresasCreadasController;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CrearEmpleadoController implements Initializable {
    ObservableList<String> txt_tipo_list= FXCollections.
            observableArrayList("Usuario");

    int telefono_;
    int saldo_;
    int sobre_giro_;
    @FXML
    private Text CrearNuevoEmpleado;
    @FXML
    private Button cerrar_sesion_button;
    @FXML
    private Button creados_button;

    @FXML
    private Button crearNuevo_button;
    @FXML
    private Button crear_button;
    @FXML
    private ImageView foto;
    @FXML
    private Text mail;
    @FXML
    private Text nombre;
    @FXML
    private Text telefono;

    @FXML
    private Text saldo;

    @FXML
    private Text sobre_giro;
    @FXML
    private Text pasaporte;
    @FXML
    private Text titulo;
    @FXML
    private Text tipo;
    @FXML
    private TextField txt_mail;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_pasaporte;
    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_saldo;
    @FXML
    private TextField txt_sobregiro;

    @FXML
    private TextField txt_contraseña;
    @FXML
    private DatePicker txt_fichamedica;
    @FXML
    private ChoiceBox<String> txt_tipo;
    @FXML
    private Label label;

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


    @FXML
    void CrearClickedButton(ActionEvent event) {
        if(!txt_nombre.getText().isEmpty() && !txt_mail.getText().isEmpty() && !txt_pasaporte.getText().isEmpty() && !txt_telefono.getText().isEmpty() && !txt_contraseña.getText().isEmpty() && !txt_saldo.getText().isEmpty() && !txt_sobregiro.getText().isEmpty()){
            telefono_ = Integer.parseInt(txt_telefono.getText());
            saldo_= Integer.parseInt(txt_saldo.getText());
            sobre_giro_= Integer.parseInt(txt_sobregiro.getText());

            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();
            Usuarios u = (Usuarios) stage1.getUserData();
            System.out.println(u.getMail());

            GetRequest response = Unirest.get("http://localhost:8080/api/v1/gimnasio/empresa/" + u.getMail())
                    .header("Content-Type", "application/json");
            String temp = response.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            List<Empresa> empresa =null;
            try {
                empresa = mapper.readValue(temp, new TypeReference<List<Empresa>>() {});
                System.out.println(empresa.get(0));

            } catch (JsonProcessingException e) {}


            Empleado empleado = new Empleado(txt_pasaporte.getText(), txt_nombre.getText(), telefono_, txt_mail.getText(), txt_contraseña.getText(), txt_fichamedica.getValue().toString(), txt_tipo.getValue(),saldo_,sobre_giro_, empresa.get(0));
            System.out.println(empleado);
            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/empleado")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(empleado).asEmpty();

            label.setText("EMPLEADO CREADO CORRECTAMENTE!");
            txt_pasaporte.setText("");
            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_mail.setText("");
            txt_contraseña.setText("");

        }else{
            System.out.println("Ingrese correctamente todos los datos para guardar una nueva Empresa");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_tipo.setItems(txt_tipo_list);
        txt_tipo.setValue("Tipo");
    }

    public String getMail_() {
        return mail_;
    }

    public void setMail_(String mail_) {
        this.mail_ = mail_;
    }
}
