package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.HorarioKey;
import com.example.usuario.usuario.Imagen;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CrearActividadController {
    ObservableList<String> txt_dia_list= FXCollections.
            observableArrayList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY", "SATURDAY","SUNDAY");
    ObservableList<String> txt_categoria_list= FXCollections.
            observableArrayList("Cancha","Gimnasio", "Exterior", "Nautico");

    int capacidad_;
    String categoria_;
    String horario_;
    String nombre_;
    int precio_;
    String descripcion_;
    int cupo_;
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
    private Text categoria;
    @FXML
    private Text horario_inicio;
    @FXML
    private Text horario_fin;
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
    private Text dia;
    @FXML
    private TextField txt_capacidad;
    @FXML
    private TextField txt_inicio;
    @FXML
    private TextField txt_fin;

    @FXML
    private Button checkin_button;
    @FXML
    private Button crearNueva_button;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_cupo;
    @FXML
    private TextField txt_descripcion;
    @FXML
    private ChoiceBox txt_categoria;

    @FXML
    private ChoiceBox txt_dia;
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
    private Label label_yacreado;

    public String mail;
    @FXML
    private Text dias;

    public Actividades actividades;

    public List<Imagen> imagenes = new ArrayList<>();

    public List<HorarioKey> horarios = new ArrayList<>();
    @FXML
    void FileChooserClickedButton(ActionEvent event) throws IOException {
/*
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes","*.jpg", "*.png"));

        List<File> f = fc.showOpenMultipleDialog(null);
        for (File file : f){

            byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
            data_ = new String(encoded, StandardCharsets.US_ASCII);
            Imagen imagenCentro = new Imagen(data_);
            imagenes.add(imagenCentro);


        byte[] byteArray = actividades.getImagen();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        Image imagen = SwingFXUtils.Image(bufferedImage, null);
         */
    }


    

    /*@FXML
    void CheckInClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(CrearActividadesController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/CheckIn-view.fxml"));
        CheckInController checkInController = fxmlLoader.getController();
        checkInController.setMail(mail);
        checkInController.info();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }*/
    @FXML
    void AdministracionClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(AdministracionController.class.getResourceAsStream("/com/example/usuario/usuario/Actividades/Administracion-view.fxml"));
        AdministracionController administracionController= fxmlLoader.getController();
        administracionController.setMail(mail);
        administracionController.informacion();

        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CrearNuevaClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividad-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CrearClickedButton(ActionEvent event) {
        System.out.println(imagenes.size());
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
            ActividadesKey actividadesKey = new ActividadesKey(centroDeportivos.get(0), txt_nombre.getText());

            HorarioKey horarioKey = new HorarioKey(txt_dia.getValue().toString(), txt_inicio.getText(), txt_fin.getText());
            horarios.add(horarioKey);

            Actividades actividades = new Actividades(actividadesKey,precio_,txt_categoria.getValue().toString(),capacidad_,txt_descripcion.getText(),cupo_ ,horarios,imagenes);
            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(actividades).asEmpty();

            txt_inicio.setText("");
            txt_fin.setText("");
            txt_nombre.setText("");
            txt_capacidad.setText("");
            txt_cupo.setText("");
            label_yacreado.setText("ACTIVIDAD CREADA CORRECTAMENTE!");

        }else{
            System.out.println("Ingrese correctamente todos los datos para guardar una nueva Empresa");
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

    @FXML
    private void initialize(){
        txt_dia.setItems(txt_dia_list);
        txt_dia.setValue("Dia");
        txt_categoria.setItems(txt_categoria_list);
        txt_categoria.setValue("Categoria");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

}




