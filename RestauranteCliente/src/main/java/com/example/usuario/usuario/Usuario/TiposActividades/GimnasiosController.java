package com.example.usuario.usuario.Usuario.TiposActividades;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Usuario.DesplegarController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GimnasiosController implements Initializable {
    Scene scene;
    Stage stage;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private Button filtrar;

    @FXML
    private ImageView foto_logo;

    @FXML
    private Button gimnasio_button;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button ver_todas_button;

    List<Actividades> actividades= new ArrayList<>();

    @FXML
    private Button reservas;

    @FXML
    void MisReservasClickedButton(ActionEvent event) {

    }
    @FXML
    void CerrrSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FiltrarClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/FiltrarPor-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void GimnasioClickedButton(ActionEvent event) {

    }

    @FXML
    void VerTodasClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades/Gimnasio")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
        }catch (Exception ignored){}
        return actividadesList;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividades.addAll(getData());
        int row=1;
        int colum =0;

        try {
            for (int i = 0; i < actividades.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Usuario/Desplegar.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarController desplegarController = fxmlLoader.getController();
                desplegarController.setData(actividades.get(i));

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

                GridPane.setMargin(anchorPane,new Insets(10));

            }
        }catch (Exception ignored){}

    }
}
