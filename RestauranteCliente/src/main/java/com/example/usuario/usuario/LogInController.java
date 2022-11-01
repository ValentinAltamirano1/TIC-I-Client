package com.example.usuario.usuario;


import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Actividades.CrearActividadesController;
import com.example.usuario.usuario.Usuario.ActividadesController;
import com.example.usuario.usuario.Usuario.Usuarios;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    private Stage stage;

    private Scene scene;

    List<Usuarios> usuarios = new ArrayList<>();

    String email_;

    String contraseña_;


    @FXML
    private AnchorPane LogInButton;

    @FXML
    private Label contraseña;

    @FXML
    private Label usuario;

    @FXML
    private Button LogIn_button;

    @FXML
    private Label titulo_bienvenidos;

    @FXML
    private TextField txt_contraseña;

    @FXML
    private TextField txt_email;

    @FXML
    void LogInClickedButton(ActionEvent event) throws IOException {
        if(!txt_contraseña.getText().isEmpty() && !txt_email.getText().isEmpty()) {
            email_ = txt_email.getText();
            contraseña_ = txt_contraseña.getText();
            String json = "";
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode rest = mapper.createObjectNode();
            rest.put("mail",email_);
            rest.put("contraseña",contraseña_);
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
            System.out.println(json);
            HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/usuarios")
                    .header("Content-Type", "application/json").body(json).asJson();
            String prueba = apiResponse.getBody().toString();
            System.out.println(prueba);
            System.out.println(apiResponse.getStatus());
            if (apiResponse.getStatus() != 400) {
                Usuarios listUser = mapper.readValue(apiResponse.getBody().toString(), new TypeReference<Usuarios>() {});
                if (listUser.getTipoUsuario().equals("superAdmin")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

                if (listUser.getTipoUsuario().equals("adminCentro")) {
                    Node node = (Node) event.getSource();
                    Stage stage1 = (Stage) node.getScene().getWindow();
                    stage1.close();


                    FXMLLoader fxmlLoader = new FXMLLoader();
                    Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/CrearActividades-view.fxml"));
                    CrearActividadesController controller = fxmlLoader.getController();
                    controller.setMail(listUser.getMail());

                    stage1.setUserData(listUser);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }


                if (listUser.getTipoUsuario().equals("adminEmpresa")){
                    Node node = (Node) event.getSource();
                    Stage stage1 = (Stage) node.getScene().getWindow();
                    stage1.close();

                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleados/Empleado-view.fxml"));

                    stage1.setUserData(listUser);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

                if (listUser.getTipoUsuario().equals("Usuario")) {
                    Node node = (Node) event.getSource();
                    Stage stage1 = (Stage) node.getScene().getWindow();
                    stage1.close();

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    Parent root = (Parent) fxmlLoader.load(LogInController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));

                    ActividadesController actividadesController = fxmlLoader.getController();
                    actividadesController.setMail(listUser.getMail());


                    stage1.setUserData(listUser);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            } else {
                System.out.println("Usuario Incorrecto");
            }
        }else{
            System.out.println("Ingrese todos los datos solicitados");
        }
    }
    @FXML
    void CancelClickedButton(ActionEvent event) {
        System.out.println("Ingrese correctamente todos los datos para acceder");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}