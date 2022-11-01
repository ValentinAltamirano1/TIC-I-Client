package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Usuario.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

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
    String fecha_;

    String data_;

    @FXML
    private Text CrearNuevaActividad;
    @FXML
    private Button fileChooser;

    @FXML
    private Text imagen;

    @FXML
    private Text capacidad;

    @FXML
    private Text fecha;

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
    private DatePicker txt_fecha;
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
    void FileChooserClickedButton(ActionEvent event) throws IOException {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes","*.jpg", "*.png"));

        List<File> f = fc.showOpenMultipleDialog(null);
        for (File file : f){
            System.out.println(file.getAbsolutePath());
        }

        FileInputStream fileInputStream = null;
        try {
            byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray((File) f));
            data_ = new String(encoded, StandardCharsets.US_ASCII);

            System.out.println(encoded);
        } catch (FileNotFoundException e) {}

        }




    @FXML
    void CrearClickedButton(ActionEvent event) {
        if(!txt_nombre.getText().isEmpty() && !txt_capacidad.getText().isEmpty() && !txt_precio.getText().isEmpty()){
            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();
            Usuarios u = (Usuarios) stage1.getUserData();
            System.out.println(u.getMail());

            GetRequest response = Unirest.get("http://localhost:8080/api/v1/gimnasio/centroDeportivo/" + u.getMail())
                    .header("Content-Type", "application/json");
            String temp = response.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            List<CentroDeportivo> centroDeportivos =null;
            try {
                centroDeportivos = mapper.readValue(temp, new TypeReference<List<CentroDeportivo>>() {});
                System.out.println(centroDeportivos.get(0));

            } catch (JsonProcessingException e) {}
            precio_= Integer.parseInt(txt_precio.getText());
            capacidad_= Integer.parseInt(txt_capacidad.getText());
            cupo_= Integer.parseInt(txt_cupo.getText());
            ActividadesKey actividadesKey = new ActividadesKey(centroDeportivos.get(0), txt_nombre.getText(), txt_horario.getValue().toString(), txt_fecha.getValue().toString());
            Actividades actividades = new Actividades(actividadesKey,precio_,txt_categoria.getValue().toString(),capacidad_,txt_descripcion.getText(),cupo_);
            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(actividades).asEmpty();


            label.setText("ACTIVIDAD CREADA CORRECTAMENTE!");
            txt_nombre.setText("");
            txt_precio.setText("");
            txt_capacidad.setText("");
            txt_descripcion.setText("");
            txt_cupo.setText("");
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




