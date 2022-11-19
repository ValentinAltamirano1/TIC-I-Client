package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Empleados.Empleado;
import com.example.usuario.usuario.Reservas;
import com.example.usuario.usuario.ReservasKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

public class DesplegarCheckInController {

    @FXML
    private Label capacidad2;

    @FXML
    private Button confirmar_button;

    @FXML
    private Label nombre2;

    @FXML
    private Label pasaporte2;

    @FXML
    private Label precio2;

    @FXML
    private Label titulo_capacidad;

    @FXML
    private Label titulo_horario;

    @FXML
    private Label titulo_nombre;

    @FXML
    private Label titulo_pasaporte;

    @FXML
    private Label titulo_precio;

    private Reservas reservas1;

    private Empleado empleados;

    public String mail;
    @FXML
    void ConfirmarClickedButton(ActionEvent event) {
        //busco empleado por mail
        System.out.println(mail);
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

        /*ReservasKey reservasKey = new ReservasKey(empleadosList.get(0),datepicker.getValue().toString(),choicebox.getValue().toString());
        Reservas reservas1 = new Reservas(this.actividades1,reservasKey,true);

        HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/reservas")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(reservas1).asEmpty();
        System.out.println(this.actividades1.getActividadesKey().getNombre());*/
    }

    public void setData1(Reservas reservas){
        this.reservas1 = reservas;
        nombre2.setText(reservas1.getActividades().getActividadesKey().getNombre());
        precio2.setText(String.valueOf(reservas1.getActividades().getPrecio()));
        capacidad2.setText(String.valueOf(reservas1.getActividades().getCapacidad()));

        //pasaporte2.setText(empleados.getPasaporte());

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

