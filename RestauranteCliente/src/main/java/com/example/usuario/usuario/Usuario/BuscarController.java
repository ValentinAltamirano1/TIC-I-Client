package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.HorarioKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BuscarController implements Initializable {

    ObservableList<String> txt_centros_list= FXCollections.
            observableArrayList();
    @FXML
    private Button actividades;

    @FXML
    private Button buscar;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private ChoiceBox choicebox;

    @FXML
    private Label cupos;

    @FXML
    private Label cupos_grande;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Label descripcion;

    @FXML
    private Label descripcion_grande;

    @FXML
    private ImageView foto_logo;

    @FXML
    private GridPane grid;

    @FXML
    private HBox nombre;

    @FXML
    private Label nombre_grande;

    @FXML
    private Label precio;

    @FXML
    private Label precio_grande;

    @FXML
    private Button reservar_button;

    @FXML
    private Button reservas;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label titulo;

    @FXML
    private ChoiceBox<?> centros_choicebox;

    @FXML
    private Label usuario_nombre;

    @FXML
    private Label usuario_nombre1;

    List<Actividades> actividades1 = new ArrayList<>();

    private MyListener myListener;

    @FXML
    void ActividadesClickedButton(ActionEvent event) {

    }
    @FXML
    void ReservarClickedButton(ActionEvent event) {

    }

    @FXML
    void BuscarClickedButton(ActionEvent event) {

    }

    @FXML
    void CerrrSesionClickedButton(ActionEvent event) {

    }

    @FXML
    void MisReservasClickedButton(ActionEvent event) {

    }

    @FXML
    void getData() {
        //conseguir centros deportivos
        GetRequest request = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo")
                .header("Content-Type", "application/json");
        String temp = request.asJson().getBody().toString();
        System.out.println(temp);
        ObjectMapper mapper = new ObjectMapper();

        List<CentroDeportivo> centros =null;
        try {
            centros = mapper.readValue(temp, new TypeReference<List<CentroDeportivo>>() {});
        } catch (JsonProcessingException e) {}
        for (int i=0;i<centros.size();i++){
            String nombreCentro = centros.get(i).getNombre();
            txt_centros_list.add(nombreCentro);
        }

        choicebox.setItems(txt_centros_list);
        choicebox.setValue("Centros Deportivos");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
