package com.example.usuario.usuario.Actividades;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VerActividadesPRUEBAController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private Button siguiente_button;

    @FXML
    private Button volver_button;

    @FXML
    private ScrollPane scroll_pane;

    @FXML
    private GridPane grid;

    private List<Actividades> actividadesList = new ArrayList<>();


    @FXML
    void SiguienteButtonClicked(ActionEvent event) {

    }

    @FXML
    void VolverButtonClicked(ActionEvent event) {

    }

    private List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();

            ObjectMapper mapper = new ObjectMapper();

            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
        }catch (Exception ignored){}
        return actividadesList;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividadesList.add((Actividades) getData());
        int column = 0;
        int row = 0;

        try {
            for (int i = 0; i < actividadesList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("com/example/usuario/usuario/Actividades/UnaActividadPRUEBA.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                UnaActividadPRUEBAController unaActividadController = fxmlLoader.getController();
                unaActividadController.setData(actividadesList.get(i));
                if (column == 1){
                    column = 0;
                    row ++;
                }
                grid.add(anchorPane, column++, row );

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
