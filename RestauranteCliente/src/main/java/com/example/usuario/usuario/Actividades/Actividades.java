package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Imagen;

import java.util.List;

public class Actividades {
    private CentroDeportivo centrosDeportivos;
    private String nombre;
    private String horario;
    private int precio;
    private String categoria;
    private int capacidad;

    private int cupos;

    private String descripcion;

    //private List<Imagen> imagen;

    public Actividades() {
    }

    public Actividades(CentroDeportivo centrosDeportivos, String nombre, String horario, int precio, String categoria, int capacidad, int cupos, String descripcion /*, List<Imagen> imagen*/) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.cupos = cupos;
        this.descripcion = descripcion;
        //this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CentroDeportivo getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentroDeportivo centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    /*public List<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(List<Imagen> imagen) {
        this.imagen = imagen;
    }
*/
    @Override
    public String toString() {
        return "Actividades{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", cupos=" + cupos +
                ", descripcion='" + descripcion + '\'' +
              //  ", imagen=" + imagen +
                '}';
    }
}
