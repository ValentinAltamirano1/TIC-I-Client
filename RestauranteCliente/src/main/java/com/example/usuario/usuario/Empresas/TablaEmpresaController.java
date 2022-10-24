package com.example.usuario.usuario.Empresas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TablaEmpresaController implements Initializable {

    @FXML
    private Text EmpresasCreadas;

    @FXML
    private Button cerrar_sesion_button;

    @FXML
    private Button cerrar_sesion_button1;

    @FXML
    private TableColumn<Empresa,String> contra;

    @FXML
    private Button crear_button;

    @FXML
    private Button crearempresa_button;

    @FXML
    private ImageView foto;

    @FXML
    private ImageView foto1;

    @FXML
    private TableColumn<Empresa,String> mail;

    @FXML
    private TableColumn<Empresa,String> nombre;

    @FXML
    private TableColumn<Empresa,String> rut;

    @FXML
    private TableView<Empresa> tableView;

    @FXML
    private TableColumn<Empresa,String> tipo;

    @FXML
    private Text titulo;

    @FXML
    private Text titulo1;

    @FXML
    private Button volver_button;

    @FXML
    private ObservableList<Empresa> list;
    @FXML
    void CerrarSesionClickedButton(ActionEvent event) {

    }

    @FXML
    void CrearClickedButton(ActionEvent event) {

    }

    @FXML
    void CrearEmpresaClickedButton(ActionEvent event) {

    }

    @FXML
    void VolverClickedButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rut.setCellValueFactory(new PropertyValueFactory<Empresa,String>("rut"));
        nombre.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nombre"));
        mail.setCellValueFactory(new PropertyValueFactory<Empresa, String>("mail"));
        contra.setCellValueFactory(new PropertyValueFactory<Empresa, String>("contra"));
        tipo.setCellValueFactory(new PropertyValueFactory<Empresa, String>("tipoA"));
        listarEmpresa();
    }

    public void listarEmpresa(){
        List<Empresa> empresas=null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/empresa")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();

            ObjectMapper mapper = new ObjectMapper();
            System.out.println(temp);
            empresas = mapper.readValue(temp, new TypeReference<List<Empresa>>(){});
            System.out.println(empresas);
            list = FXCollections.observableArrayList(empresas);

            tableView.setItems(list);

        }catch (Exception ignored){}


    }
}

