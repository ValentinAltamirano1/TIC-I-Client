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

import java.awt.event.MouseEvent;
import java.util.List;

public class DesplegarController {

    @FXML
    private Label cupos1;
    @FXML
    private Label horario1;

    @FXML
    private Label nombre1;

    @FXML
    private Label precio1;

    @FXML
    private Button reserva_button;

    @FXML
    private Button atras_button;

    @FXML
    private Button siguiente_button;
    @FXML
    private Label titulo_cupos;

    @FXML
    private Label titulo_horario;

    @FXML
    private Label titulo_nombre;

    @FXML
    public void click(javafx.scene.input.MouseEvent mouseEvent) {
        myListener.onClickListener(actividades);
    }

    public void AtrasClickedButton(ActionEvent actionEvent) {

    }

    public void SiguienteClickedButton(ActionEvent actionEvent) {
    }



    @FXML
    private Label titulo_precio;

    private Actividades actividades;
    private MyListener myListener;

    public void setData(Actividades actividades, MyListener myListener){
        this.actividades = actividades;
        this.myListener = myListener;
        nombre1.setText(actividades.getActividadesKey().getNombre());
        precio1.setText(String.valueOf(actividades.getPrecio()));
        horario1.setText(String.valueOf(actividades.getHorarios().get(0).getDia_de_semana()));
        cupos1.setText(String.valueOf(actividades.getCupos()));
    }


}

