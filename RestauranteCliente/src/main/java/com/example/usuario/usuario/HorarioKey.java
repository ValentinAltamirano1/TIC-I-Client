package com.example.usuario.usuario;


import java.io.Serializable;


public class HorarioKey implements Serializable {

    private String dia_de_semana;


    private String horario_inicio;


    private String horario_fin;

    public HorarioKey() {

    }

    public String getDia_de_semana() {
        return dia_de_semana;
    }

    public void setDia_de_semana(String dia_de_semana) {
        this.dia_de_semana = dia_de_semana;
    }

    public String getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(String horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public String getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(String horario_fin) {
        this.horario_fin = horario_fin;
    }

    public HorarioKey(String dia_de_semana, String horario_inicio, String horario_fin) {
        this.dia_de_semana = dia_de_semana;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    @Override
    public String toString() {
        return "HorarioKey{" +
                "dia_de_semana='" + dia_de_semana + '\'' +
                ", horario_inicio='" + horario_inicio + '\'' +
                ", horario_fin='" + horario_fin + '\'' +
                '}';
    }
}
