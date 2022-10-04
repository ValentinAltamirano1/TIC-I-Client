package com.example.usuario.usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CentroDeportivoController {
    List<String> centrosDeportivos = new ArrayList<>();
    private Stage stage;
    private Scene scene;

    String nombre_;
    Long rut_;
    Long telefono_;
    String direccion_;

    @FXML
    private Button cancelar_button;

    @FXML
    private Button crear_button;

    @FXML
    private Label direccion;

    @FXML
    private Label nombre;

    @FXML
    private Label rut;

    @FXML
    private Label telefono;

    @FXML
    private Label titulo;

    @FXML
    private TextField txt_direccion;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_rut;

    @FXML
    private TextField txt_telefono;

    public List<String> getCentrosDeportivos() {return centrosDeportivos;}

    public void setCentrosDeportivos(List<String> centrosDeportivos) {this.centrosDeportivos = centrosDeportivos;}

    @FXML
    void CancelarClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearClickedButton(ActionEvent event) {
        if(!txt_nombre.getText().isEmpty() && !txt_rut.getText().isEmpty() && !txt_telefono.getText().isEmpty() && !txt_direccion.getText().isEmpty()){
            try {
                nombre_ = txt_nombre.getText();
                rut_ = Long.parseLong(txt_rut.getText());
                telefono_ = Long.parseLong(txt_telefono.getText());
                direccion_ = txt_direccion.getText();
                String json = "";
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode rest = mapper.createObjectNode();
                    centrosDeportivos.add(nombre_); //para agregarlo a la lista
                    rest.put("nombre", nombre_);
                    rest.put("rut", rut_);
                    rest.put("telefono", telefono_);
                    rest.put("direccion", direccion_);
                    json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
                } catch (Exception ignored) {
                }
                try {
                   HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v1/centroDeportivo")
                           .header("Content-Type", "application/json").body(json).asJson();
                } catch (UnirestException ex) {}
            }catch (NumberFormatException e){}
            }
            else {
                System.out.println("Ingrese correctamente todos los datos para guardar un nuevo Centro Deportivo");
            }
            //CentroDeportivo nuevoCentroDeportivo = new CentroDeportivo(nombre, rut, direccion, telefono);
            //centro_deportivo.addNewCentroDeportivo(nuevoCentroDeportivo);

    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
