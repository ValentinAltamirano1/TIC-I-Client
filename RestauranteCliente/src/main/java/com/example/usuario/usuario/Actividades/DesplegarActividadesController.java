package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.Imagen;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        try {
            File f = new File(imagen);
            byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray((File) f));
            String data_ = new String(encoded, StandardCharsets.US_ASCII);

            System.out.println(encoded);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}

