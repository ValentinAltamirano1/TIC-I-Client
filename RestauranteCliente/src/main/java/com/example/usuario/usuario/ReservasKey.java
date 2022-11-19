package com.example.usuario.usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.example.usuario.usuario.Empleados.Empleado;

public class ReservasKey  {

    private Empleado empleados;

    private String fecha;

    private String horario;

    public ReservasKey(Empleado empleados, String fecha, String horario) {
        this.empleados = empleados;
        this.fecha = fecha;
        this.horario = horario;
    }

    public ReservasKey() {
    }

    public Empleado getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados = empleados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "ReservasKey{" +
                "empleados=" + empleados +
                ", fecha='" + fecha + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
