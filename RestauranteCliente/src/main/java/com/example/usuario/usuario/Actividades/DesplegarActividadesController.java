package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Imagen;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

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

    @FXML
    private ImageView imagen;
    private Actividades actividades;

    public void setData(Actividades actividades) {
        this.actividades = actividades;
        nombre.setText(actividades.getActividadesKey().getNombre());
        precio.setText(String.valueOf(actividades.getPrecio()));
        descripcion.setText(actividades.getDescripcion());
        capacidad.setText(String.valueOf(actividades.getCapacidad()));
        categoria.setText(actividades.getCategoria());
        cupos.setText(String.valueOf(actividades.getCupos()));
    }

    public Image decodificar(String imagen) {
        byte[] imageDecoded = Base64.getDecoder().decode(imagen);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageDecoded);
        BufferedImage bufferedImage = null;
        try{
            bufferedImage = ImageIO.read(byteArrayInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        Image agregar = SwingFXUtils.toFXImage(bufferedImage, null);
        return agregar;

    }

}