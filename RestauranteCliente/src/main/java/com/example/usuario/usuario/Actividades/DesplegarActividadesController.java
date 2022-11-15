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
            //HACER LOS SET TEXT

    }
}
