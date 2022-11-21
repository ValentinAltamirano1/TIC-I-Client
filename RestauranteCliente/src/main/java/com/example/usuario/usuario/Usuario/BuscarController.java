package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.HorarioKey;
import com.example.usuario.usuario.Reservas;
import com.example.usuario.usuario.ReservasKey;
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
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BuscarController implements Initializable {

    ObservableList<String> txt_centros_list= FXCollections.
            observableArrayList();

    ObservableList<String> txt_horarios_list= FXCollections.
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
    private Label label_hola;

    @FXML
    private Label label_pesos;

    @FXML
    private Label label_saldo;
    @FXML
    private Label usuario_nombre;

    @FXML
    private Label usuario_saldo;

    public Label getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(Label usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public Label getUsuario_saldo() {
        return usuario_saldo;
    }

    public void setUsuario_saldo(Label usuario_saldo) {
        this.usuario_saldo = usuario_saldo;
    }
    @FXML
    private ChoiceBox centros_choicebox;

    @FXML
    private Label usuario_nombre1;

    List<Actividades> actividades1 = new ArrayList<>();

    private MyListener myListener;

    String mail;

    public String diaSemana;

    public Actividades actividades_;
    @FXML
    void ActividadesClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(ActividadesController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));
        ActividadesController actividadesController = fxmlLoader.getController();
        actividadesController.getEmpleado();
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void ReservarClickedButton(ActionEvent event) throws IOException {
        List<Empleado> empleadosList = null;
        if (!(datepicker.getValue() ==null) && !(choicebox.getValue() == null)){

            //busco empleado por mail
            GetRequest requestEmp = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + mail)
                    .header("Content-Type", "application/json");
            String temp1 = requestEmp.asJson().getBody().toString();
            System.out.println(temp1);
            ObjectMapper mapper1 = new ObjectMapper();
            try {
                empleadosList =mapper1.readValue(temp1, new TypeReference<List<Empleado>>() {});
                System.out.println(empleadosList);
            } catch (JsonProcessingException e) {}

            ReservasKey reservasKey = new ReservasKey(empleadosList.get(0),datepicker.getValue().toString(),choicebox.getValue().toString());
            Reservas reservas1 = new Reservas(actividades_,reservasKey,false,"reservado");

            HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/reservas")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(reservas1).asEmpty();

            Actividades actividades2 = new Actividades(actividades_.getActividadesKey(),actividades_.getPrecio(),actividades_.getCategoria(),actividades_.getCapacidad(),actividades_.getDescripcion(),actividades_.getCupos(),actividades_.getHorarios(),actividades_.getImagen());
            HttpResponse apiResponse1 =  Unirest.post("http://localhost:8080/api/v1/gimnasio/actividades/update")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(actividades2).asEmpty();


        }else{
            System.out.println("Ingrese todos los datos para poder realizar una reserva");
        }
    }

    @FXML
    void BuscarClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(BuscarController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/Buscar-view.fxml"));
        BuscarController buscarController = fxmlLoader.getController();
        buscarController.getDataCentro();
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void CerrrSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        Stage stage;
        Scene scene;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void getDataCentro() {
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

        centros_choicebox.setItems(txt_centros_list);
        centros_choicebox.setValue("Centros Deportivos");
    }

    public List<Actividades> getData(){
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades/nombre/"+centros_choicebox.getValue().toString())
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
            System.out.println(actividadesList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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

    public void mostrar(){
        grid = new GridPane();
        scroll.setContent(grid);
        choicebox.setItems(txt_horarios_list);
        choicebox.setValue("Horario");
        actividades1.clear();
        actividades1.addAll(getData());
        if(actividades1.size()>0){
            setChosenActivity(actividades1.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Actividades actividades) {

                    setChosenActivity(actividades);
                    setActividades_(actividades);
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

    public Actividades getActividades_() {
        return actividades_;
    }

    public void setActividades_(Actividades actividades_) {
        this.actividades_ = actividades_;
    }

    public void getDate(ActionEvent actionEvent) {
        choicebox.getItems().clear();
        LocalDate date = datepicker.getValue();
        System.out.println(date.toString());

        diaSemana = date.getDayOfWeek().toString();
        System.out.println(diaSemana);
        System.out.println(actividades_.getActividadesKey().getNombre());
        System.out.println(actividades_.getActividadesKey().getCentrosDeportivos().getRut());

        //conseguir horarios segun la actividad con el dia de la semana
        GetRequest request = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades/horario/" + diaSemana + "/" + actividades_.getActividadesKey().getNombre()
                        + "/" + actividades_.getActividadesKey().getCentrosDeportivos().getRut())
                .header("Content-Type", "application/json");
        String temp = request.asJson().getBody().toString();
        System.out.println(temp);
        ObjectMapper mapper = new ObjectMapper();

        List<HorarioKey> horarioKeys =null;
        try {
            horarioKeys = mapper.readValue(temp, new TypeReference<List<HorarioKey>>() {});
        } catch (JsonProcessingException e) {}

        if (horarioKeys.size()==0){
            txt_horarios_list.add("                      ");
        }


        for (int i=0; i<horarioKeys.size();i++) {
            String horarioInicio = horarioKeys.get(i).getHorario_inicio();
            txt_horarios_list.add(horarioInicio);
        }
    }

    Empleado empleado;
    public void getEmpleado(){
        List<Empleado> empleadosList = null;
        GetRequest requestEmp = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + mail)
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

