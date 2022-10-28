package com.example.usuario.usuario.Actividades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CrearActividadesController {
    ObservableList<String> txt_horario_list= FXCollections.
            observableArrayList("9:00","10:00","11:00","14:00","15:00","16:00","17:00","18:00");
    ObservableList<String> txt_categoria_list= FXCollections.
            observableArrayList("Cancha","Gimnasio", "Exterior", "Nautico");
    Stage stage;
    Scene scene;

    int capacidad_;
    String categoria_;
    String horario_;
    String nombre_;
    int precio_;
    String descripcion_;
    int cupo_;

    ImageView foto_;

    @FXML
    private Text CrearNuevaActividad;
    @FXML
    private Button fileChooser;

    @FXML
    private Text imagen;

    @FXML
    private Text capacidad;

    @FXML
    private Text categoria;

    @FXML
    private Text horario;

    @FXML
    private Text nombre;

    @FXML
    private Text fichamedica;

    @FXML
    private Text contraseña;

    @FXML
    private Text descripcion;
    @FXML
    private Text cupo;

    @FXML
    private Text precio;

    @FXML
    private TextField txt_capacidad;

    @FXML
    private ChoiceBox txt_horario;

    @FXML
    private Button checkin_button;

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_cupo;
    @FXML
    private TextField txt_descripcion;
    @FXML
    private ChoiceBox txt_categoria;

    @FXML
    private TextField txt_precio;

    @FXML
    private Button crear_button;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button creados_button;

    @FXML
    private ImageView foto;

    @FXML
    private Text titulo;

    @FXML
    private Label label;
    @FXML
    void FileChooserClickedButton(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes", "png"));
        File f = fc.showOpenDialog(null);

        if(f != null){
            fileChooser.setText("Selected Image:" + f.getAbsolutePath());
        }

    }

    @FXML
    void CrearClickedButton(ActionEvent event) {
        if(!txt_nombre.getText().isEmpty() && !txt_capacidad.getText().isEmpty() && !txt_precio.getText().isEmpty()){
            try {
                nombre_ = txt_nombre.getText();
                capacidad_ = Integer.parseInt(txt_capacidad.getText());
                precio_= Integer.parseInt(txt_precio.getText());
                horario_ = txt_horario.getValue().toString();
                categoria_ = txt_categoria.getValue().toString();
                descripcion_ = txt_descripcion.getText();
                cupo_ = Integer.parseInt(txt_cupo.getText());
                String json = "";

                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode rest = mapper.createObjectNode();
                    rest.put("nombre", nombre_);
                    rest.put("horario",horario_ );
                    rest.put("precio", precio_);
                    rest.put("categoria",categoria_ );
                    rest.put("capacidad",capacidad_ );
                    rest.put("descripcion", descripcion_);
                    rest.put("cupo", cupo_);
                    json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rest);
                }catch (Exception ignored) {
                }
                try {
                    HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/actividades")
                            .header("Content-Type", "application/json").body(json).asJson();


                    label.setText("ACTIVIDAD CREADA CORRECTAMENTE!");
                    txt_nombre.setText("");
                    txt_precio.setText("");
                    txt_capacidad.setText("");
                    txt_descripcion.setText("");
                    txt_cupo.setText("");

                }catch (UnirestException ex) {}
            }catch (NumberFormatException e){}
        }else{
            System.out.println("Ingrese correctamente todos los datos para guardar una nueva Empresa");
        }
    }
    @FXML
    void CerrarSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CreadosClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/TablaActividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/TablaActividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize(){
        txt_horario.setItems(txt_horario_list);
        txt_horario.setValue("Horario");
        txt_categoria.setItems(txt_categoria_list);
        txt_categoria.setValue("Categoria");
    }

}




