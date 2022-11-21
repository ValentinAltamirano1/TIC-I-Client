package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Pagos.Pagos;
import com.example.usuario.usuario.Reservas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DesplegarAdministracionController {

    @FXML
    private Label empresa;

    @FXML
    private Label monto;

    @FXML
    private Label rut;

    private Pagos pagos;

    public void setData1(Pagos pagos){
        this.pagos = pagos;
        empresa.setText(pagos.getPagosKey().getEmpresas().getNombre());
        rut.setText(String.valueOf(pagos.getPagosKey().getEmpresas().getRut()));
        monto.setText(String.valueOf(pagos.getGasto()));

    }

}
