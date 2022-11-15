package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
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
import javafx.scene.layout.*;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckInController implements Initializable {
    Scene scene;

    Stage stage;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button checkin_button;

    @FXML
    private Text confirmar;

    @FXML
    private Text copia_confirmar;

    @FXML
    private Button creados_button;

    @FXML
    private Button crearNueva_button;

    @FXML
    private ImageView foto;

    @FXML
    private GridPane grid;

    @FXML
    private Label label;

    @FXML
    private Button noreservados;

    @FXML
    private ScrollPane scroll1;

    @FXML
    private Text titulo;


    java.util.List<Actividades> actividades1 = new ArrayList<>();

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String mail;

    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CheckIn-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/TablaActividades-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividades-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void NoReservadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/SinReserva-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public List<Actividades> getDataCentro(String mail) {
        System.out.println(mail);
        //agarro las actividades del centro
        List<CentroDeportivo> centrosDepor = null;
        List<Actividades> actividadesCentro = null;
        try {
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo/" + mail)
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            centrosDepor = mapper.readValue(temp, new TypeReference<List<CentroDeportivo>>() {
            });
            System.out.println(centrosDepor);
        } catch (Exception ignored) {
        }

        //con el centro deportivo, busco las reservas asociadas al centro
        GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/reservas/getRut/" + centrosDepor.get(0).getRut())
                .header("Content-Type", "application/json");
        String temp1 = apiResponse.asJson().getBody().toString();
        System.out.println(temp1);
        ObjectMapper mapper1 = new ObjectMapper();
        try {
            actividadesCentro = mapper1.readValue(temp1, new TypeReference<List<Actividades>>() {
            });
        } catch (Exception e) {
        }
        System.out.println(actividadesCentro);
        return actividadesCentro;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    /*    System.out.println(mail);
        actividades1.addAll(getDataCentro(mail));
        System.out.println(actividades1.addAll(getDataCentro(mail)));
        int row = 1;
        int colum = 0;

        try {
            for (int i = 0; i < actividades1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Actividades/DesplegarCheckIn.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarCheckInController desplegarCheckInController = fxmlLoader.getController();
                desplegarCheckInController.setData1(actividades1.get(i));

                if (colum == 1) {
                    colum = 0;
                    row++;
                }

                grid1.add(anchorPane, colum++, row);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_COMPUTED_SIZE);

                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception ignored) {
        }*/


    }

    public void info () {
        actividades1.addAll(getDataCentro(mail));
        int row = 1;
        int colum = 0;

        try {
            for (int i = 0; i < actividades1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Actividades/DesplegarCheckIn.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarCheckInController desplegarCheckInController = fxmlLoader.getController();
                desplegarCheckInController.setData1(actividades1.get(i));

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
