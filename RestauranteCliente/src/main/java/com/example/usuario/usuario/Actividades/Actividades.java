package com.example.usuario.usuario.Actividades;

import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Imagen;

import java.util.List;

public class Actividades {

   /* @ManyToMany(mappedBy = "actividades")
    private List<Empleados> empleados=new ArrayList<>() ;

    /*@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "actividades_empleados_mapping")
    @JoinColumn(name = "id_actividad")
    @JoinColumn(name = "id_empleado")
    private Set<Empleados> empleados;*/



    /*@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "rut")
    private CentrosDeportivos centrosDeportivos; // muchos actividades pueden pertenecer a un mismo centro deportivo

   /* @OneToMany
    @JoinColumn(name = "id_actividad")
    private Set<Imagenes> imagenes;*/


    private ActividadesKey actividadesKey;
    private int precio;

    private String categoria;
    private int capacidad;

    private String descripcion;

    private int cupos;

    //@Column(name = "imagen", nullable = false)
    //private List<Imagenes> imagen;


    public Actividades() {
    }

    public Actividades(ActividadesKey actividadesKey, int precio, String categoria, int capacidad, String descripcion, int cupos) {
        this.actividadesKey = actividadesKey;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.cupos = cupos;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
/*
    public List<Imagenes> getImagen() {
        return imagen;
    }

    public void setImagen(List<Imagenes> imagen) {
        this.imagen = imagen;
    }*/

    public ActividadesKey getActividadesKey() {
        return actividadesKey;
    }

    public void setActividadesKey(ActividadesKey actividadesKey) {
        this.actividadesKey = actividadesKey;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "actividadesKey=" + actividadesKey +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                ", cupos=" + cupos +
                '}';
    }
}
