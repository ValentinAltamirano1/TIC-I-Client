package com.example.usuario.usuario;

import com.example.usuario.usuario.Empleados.Empleado;

public class ReservasKey {

    private Empleado empleados;

    public ReservasKey(Empleado empleados) {
        this.empleados = empleados;
    }

    public Empleado getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "ReservasKey{" +
                "empleados=" + empleados +
                '}';
    }
}
