package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.DesplegarCentrosController;
import com.example.usuario.usuario.Pagos.Pagos;
import com.example.usuario.usuario.Usuario.DesplegarController;
import com.example.usuario.usuario.Usuario.MyListener;
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
import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdministracionController implements Initializable {

    @FXML
    private Button administracion;

    @FXML
    private Label centrosdeportivos;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button checkin_button;

    @FXML
    private Button creados_button;

    @FXML
    private Button crearNueva_button;

    @FXML
    private ImageView foto;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label titulo_uno;

    List<Pagos> pagos = new ArrayList<>();

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String mail;

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
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividad-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void CheckInClickedButton(ActionEvent actionEvent) {
        try {
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
        } catch (Exception e) {

        }
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
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/ActividadesCreadas-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void informacion(){
        HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/pagos")
                .header("accept", "application/json")
                .header("Content-Type", "application/json").body("").asEmpty();
    }

    public List<Pagos> getData() {
        List<Pagos> pagosList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/pagos")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            ObjectMapper mapper = new ObjectMapper();
            pagosList = mapper.readValue(temp, new TypeReference<List<Pagos>>(){});
            System.out.println(pagosList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return pagosList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pagos.addAll(getData());

        int row = 1;
        int colum = 0;

        try {
            for (int i = 0; i < pagos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Actividades/DesplegarAdministracion-view.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarAdministracionController desplegarAdministracionController = fxmlLoader.getController();
                desplegarAdministracionController.setData1(pagos.get(i));

                if (colum == 2) {
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
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
