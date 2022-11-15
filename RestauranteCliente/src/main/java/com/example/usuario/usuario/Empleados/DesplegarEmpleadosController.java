package com.example.usuario.usuario.Empleados;

import com.example.usuario.usuario.Empleados.Empleado;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DesplegarEmpleadosController {

    @FXML
    private Label contrasena;

    @FXML
    private Label fichamedica;

    @FXML
    private Label mail;

    @FXML
    private Label nombre;

    @FXML
    private Label pasaporte;

    @FXML
    private Label saldo;

    @FXML
    private Label sobregiro;

    @FXML
    private Label telefono;

    @FXML
    private Label tipo;

    private Empleado empleados;

    public void setData(Empleado empleados){
        this.empleados = empleados;
        nombre.setText(empleados.getNombre());
        pasaporte.setText(empleados.getPasaporte());
        telefono.setText(String.valueOf(empleados.getTelefono()));
        fichamedica.setText(empleados.getFicha_medica());
        saldo.setText(String.valueOf(empleados.getSaldo()));
        sobregiro.setText(String.valueOf(empleados.getSobre_giro()));
        mail.setText(empleados.getMail());
        contrasena.setText(empleados.getContraseña());
        tipo.setText(empleados.getTipo());
    }
}
