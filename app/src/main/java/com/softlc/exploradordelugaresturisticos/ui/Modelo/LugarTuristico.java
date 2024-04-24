package com.softlc.exploradordelugaresturisticos.ui.Modelo;

import java.io.Serializable;

public class LugarTuristico implements Serializable {

    private String nombre;
    private String descripcion;

    private int foto;

    private String horario;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public LugarTuristico(String nombre, String descripcion, int foto,String horario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
