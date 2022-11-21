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

        Reservas reservas = new Reservas(reservas1.getActividades(),reservas1.getReservasKey(),true,"reservado");

        HttpResponse apiResponse = Unirest.post("http://localhost:8080/api/v1/gimnasio/reservas/update")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(reservas).asEmpty();

    }

    public void setData1(Reservas reservas){
        this.reservas1 = reservas;
        nombre2.setText(reservas1.getActividades().getActividadesKey().getNombre());
        precio2.setText(String.valueOf(reservas1.getActividades().getPrecio()));
        capacidad2.setText(String.valueOf(reservas1.getActividades().getCapacidad()));
        pasaporte2.setText(reservas1.getReservasKey().getEmpleados().getPasaporte());

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}

