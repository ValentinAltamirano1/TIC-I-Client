package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Application;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ActividadesController implements Initializable {
    Scene scene;

    Stage stage;
    @FXML
    private ImageView canchas;

    @FXML
    private Button canchas_button;

    @FXML
    private ImageView exterior;

    @FXML
    private Button exterior_button;

    @FXML
    private ImageView gimnasios;

    @FXML
    private Button gimnasios_button;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView nautica;

    @FXML
    private Button nautica_button;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private GridPane grid;

    List<Actividades> actividades= new ArrayList<>();

    private List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
            }
        catch (Exception ignored){}
        return actividadesList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividades.addAll(getData());
        System.out.println(getData());
         int row=1;
         int colum =0;
         try {
             for (int i = 0; i < actividades.size(); i++) {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("com.example.usuario.usuario.Actividades.Desplegar.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();


                 DesplegarController desplegarController = fxmlLoader.getController();
                 desplegarController.setData(actividades.get(i));

                 if (colum == 1) {
                     colum = 0;
                     row++;
                 }

                 grid.add(anchorPane, colum++, row);
                 GridPane.setMargin(anchorPane,new Insets(10));


             }
         }catch (Exception ignored){

         }
    }
}
