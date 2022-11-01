package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.Empresas.Empresa;
import com.example.usuario.usuario.Reservas;
import com.example.usuario.usuario.ReservasKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

public class DesplegarController {

    @FXML
    private Label capacidad1;

    @FXML
    private Label horario1;

    @FXML
    private Label nombre1;

    @FXML
    private Label precio1;

    @FXML
    private Button reserva_button;

    @FXML
    private Label titulo_capacidad;

    @FXML
    private Label titulo_horario;

    @FXML
    private Label titulo_nombre;

    @FXML
    private Label titulo_precio;

    private Actividades actividades;

    @FXML
    void ReservarClickedButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();
        Usuarios u = (Usuarios) stage1.getUserData();
        System.out.println(u.getMail());

        GetRequest response = Unirest.get("http://localhost:8080/api/v1/gimnasio/empleado/" + u.getMail())
                .header("Content-Type", "application/json");
        String temp = response.asJson().getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        List<Empleado> empleados =null;
        try {
            empleados = mapper.readValue(temp, new TypeReference<List<Empleado>>() {});
            System.out.println(empleados.get(0));

        } catch (JsonProcessingException e) {}

        //tabla reservas con datos de la actividad y del usuario
        ReservasKey reservasKey = new ReservasKey(empleados.get(0));
        Reservas reservas = new Reservas(actividades,reservasKey);
        System.out.println(reservas);


        HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/reservas")
                .header("accept","application/json" )
                .header("Content-Type", "application/json")
                .body(reservas).asEmpty();
        // Falta hacer que se reste un cupo y en caso de que quede solo 1 que se elimine la actividad
    }

    public void setData(Actividades actividades){
        this.actividades = actividades;
        nombre1.setText(actividades.getActividadesKey().getNombre());
        precio1.setText(String.valueOf(actividades.getPrecio()));
        horario1.setText(actividades.getActividadesKey().getHorario());
        capacidad1.setText(String.valueOf(actividades.getCapacidad()));
    }

}

