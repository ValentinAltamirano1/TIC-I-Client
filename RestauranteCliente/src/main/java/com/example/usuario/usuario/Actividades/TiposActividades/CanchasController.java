package com.example.usuario.usuario.Actividades.TiposActividades;

import com.example.usuario.usuario.Actividades.Actividades;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CanchasController implements Initializable {
     Scene scene;
     Stage stage;
    List<Actividades> actividadesCancha= new ArrayList<>();
    @FXML
    private Label capacidad1;

    @FXML
    private Label capacidad2;

    @FXML
    private Label capacidad3;

    @FXML
    private Label horario1;

    @FXML
    private Label horario2;

    @FXML
    private Label horario3;

    @FXML
    private Label nombre1;

    @FXML
    private Label nombre2;

    @FXML
    private Label nombre3;

    @FXML
    private Label precio1;

    @FXML
    private Label precio2;

    @FXML
    private Label precio3;

    @FXML
    private Button canchas_button;

    @FXML
    private Button siguiente_button;

    @FXML
    private Button volver_button;

    @FXML
    private GridPane grid;

    @FXML
    void VolverButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Actividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void SiguienteButtonClicked(ActionEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Actividades> desplegar = getData();
       /* int row=0;
        for (int i= 0; i<desplegar.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("com.example.usuario.usuario.Actividades.Actividades-view.fxml"));
            try {
                AnchorPane anchorPane = fxmlLoader.load();
                UnaActividadPRUEBAController controller = fxmlLoader.getController();
                controller.setData(desplegar.get(i));
                grid.add(anchorPane, 0,0 );
                GridPane.setMargin(anchorPane,new Insets(10));
            } catch (IOException e) {}
        }
*/
    }

    private List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            System.out.println("HOLA");
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            System.out.println("HOLA");
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
            System.out.println(actividadesList);
            for(int i=0; i<actividadesList.size(); i++){
                if(actividadesList.get(i).getCategoria().equals("Cancha")){
                    actividadesCancha.add(actividadesList.get(i));
                }
            }
        }catch (Exception ignored){}
        return actividadesCancha;
    }

}
