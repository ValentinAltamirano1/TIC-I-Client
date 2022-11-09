package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.LogInController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MisReservasController implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private Button actividades;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private Button filtrar;

    @FXML
    private ImageView foto_logo;

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid1;

    @FXML
    private Button reservas;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ScrollPane scroll_empleado;

    @FXML
    private Label titulo;

    public String mail;


    @FXML
    void ActividadesClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrrSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FiltrarClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/FiltrarPor-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MisReservasClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/MisReservas-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    List<Actividades> actividades1 = new ArrayList<>();

    public List<Actividades> getDataUsuario(String mail) {
        List<Empleado> empleadosList = null;
        List<Actividades> actividadesList = null;
        try {
            //busco empleado por mail
            GetRequest requestEmp = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + mail)
                    .header("Content-Type", "application/json");
            String temp1 = requestEmp.asJson().getBody().toString();
            System.out.println(temp1);
            ObjectMapper mapper1 = new ObjectMapper();
            empleadosList =mapper1.readValue(temp1, new TypeReference<List<Empleado>>() {});
            System.out.println(empleadosList);

            //con el empleado, busco las reservas asociadas al mismo
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/reservas/"+ empleadosList.get(0).getPasaporte())
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>() {});
            System.out.println(actividadesList);
        } catch (Exception ignored) {
        }
        return actividadesList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

   /* public void inf(){
        System.out.println(mail);
        actividades1.addAll(getDataUsuario(mail));
        int row = 1;
        int colum = 0;

        try {
            for (int i = 0; i < actividades1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Usuario/Desplegar.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarController desplegarController = fxmlLoader.getController();
                desplegarController.setData(actividades1.get(i));

                if (colum == 1) {
                    colum = 0;
                    row++;
                }

                grid.add(anchorPane, colum++, row);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception ignored) {
        }
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    */
}

