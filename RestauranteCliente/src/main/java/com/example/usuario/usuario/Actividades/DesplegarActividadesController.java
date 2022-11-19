package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DesplegarActividadesController {

    @FXML
    private Label capacidad;

    @FXML
    private Label categoria;

    @FXML
    private Label cupos;

    @FXML
    private Label descripcion;

    @FXML
    private Label nombre;

    @FXML
    private Label precio;


    private Actividades actividades;

    public void setData(Actividades actividades){
        this.actividades = actividades;
        nombre.setText(actividades.getActividadesKey().getNombre());
        precio.setText(String.valueOf(actividades.getPrecio()));
        descripcion.setText(actividades.getDescripcion());
        capacidad.setText(String.valueOf(actividades.getCapacidad()));
        categoria.setText(actividades.getCategoria());
        cupos.setText(String.valueOf(actividades.getCupos()));
    }
}
