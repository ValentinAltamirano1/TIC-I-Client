package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Actividades.CrearActividadController;
import com.example.usuario.usuario.Empleados.Empleado;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MisReservasController implements Initializable {

    @FXML
    private Button actividades;

    @FXML
    private Button buscar;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private ChoiceBox<?> choicebox;

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
    private Label usuario_nombre;
    @FXML
    private Label usuario_saldo;

    @FXML
    private Label label_hola;

    @FXML
    private Label label_pesos;

    @FXML
    private Label label_saldo;

    @FXML
    private Button reservas;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label titulo;



    public String mail;
    private MyListener myListener;
    List<Actividades> actividades1 = new ArrayList<>();

    @FXML
    void ActividadesClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(MisReservasController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));
        ActividadesController controller = fxmlLoader.getController();
        controller.setMail(mail);
        controller.getEmpleado();

        Stage stage = new Stage();
        Scene scene;

        stage.setUserData("vale");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrrSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void MisReservasClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(ActividadesController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/MisReservas-view.fxml"));
        MisReservasController misReservasController = fxmlLoader.getController();
        misReservasController.setMail(mail);
        misReservasController.getinf();
        misReservasController.getEmpleado();
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void CancelarReservaClickedButton(ActionEvent actionEvent) {
    }

    public List<Actividades> getDataUsuario(String mail) {
        List<Empleado> empleadosList = null;
        List<Actividades> actividadesList = null;
        try {
            //busco empleado por mail
            GetRequest requestEmp = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + mail)
                    .header("Content-Type", "application/json");
            String temp1 = requestEmp.asJson().getBody().toString();
            System.out.println(temp1);
            ObjectMapper mapper1 = new ObjectMapper();
            empleadosList =mapper1.readValue(temp1, new TypeReference<List<Empleado>>() {});
            System.out.println(empleadosList);

            //con el empleado, busco las reservas asociadas al mismo
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/reservas/"+ empleadosList.get(0).getPasaporte())
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>() {});
            System.out.println(actividadesList);
        } catch (Exception ignored) {
        }
        return actividadesList;
    }
    private void setChosenActivity(Actividades actividades){
        nombre_grande.setText(actividades.getActividadesKey().getNombre());
        cupos_grande.setText(String.valueOf(actividades.getCupos()));
        descripcion_grande.setText(actividades.getDescripcion());
        precio_grande.setText(String.valueOf(actividades.getPrecio()));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void BuscarClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(BuscarController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/Buscar-view.fxml"));
        BuscarController buscarController = fxmlLoader.getController();

        buscarController.setMail(mail);
        buscarController.getDataCentro();
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getinf(){
        actividades1.addAll(getDataUsuario(mail));
        if(actividades1.size()>0){
            setChosenActivity(actividades1.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Actividades actividades) {
                    setChosenActivity(actividades);
                }
            };
        }
        int row = 1;
        int colum = 0;

        try {
            for (int i = 0; i < actividades1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Usuario/Desplegar.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                DesplegarController desplegarController = fxmlLoader.getController();
                desplegarController.setData(actividades1.get(i), myListener);

                if (colum == 2) {
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
        } catch (Exception ignored) {
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void getDate(ActionEvent actionEvent) {
    }
    Empleado empleado;
    public void getEmpleado(){
        List<Empleado> empleadosList = null;
        kong.unirest.GetRequest requestEmp = kong.unirest.Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + mail)
                .header("Content-Type", "application/json");
        String temp1 = requestEmp.asJson().getBody().toString();
        System.out.println(temp1);
        ObjectMapper mapper1 = new ObjectMapper();
        try {
            empleadosList =mapper1.readValue(temp1, new TypeReference<List<Empleado>>() {});
            System.out.println(empleadosList);
        } catch (JsonProcessingException e) {}

        empleado = empleadosList.get(0);
        usuario_saldo.setText(String.valueOf(empleadosList.get(0).getSaldo()));
        usuario_nombre.setText(empleadosList.get(0).getNombre());
    }
}

