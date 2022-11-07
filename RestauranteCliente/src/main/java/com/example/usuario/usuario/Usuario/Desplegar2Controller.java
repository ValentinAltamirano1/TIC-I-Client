package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Desplegar2Controller {

    @FXML
    private ImageView foto_usuario;

    @FXML
    private Label nombre;

    List<Usuarios> usuarios = new ArrayList<>();

    public void setData2(Usuarios usuarios){
        this.usuarios = (List<Usuarios>) usuarios;
        nombre.setText(usuarios.getMail());
    }

}

