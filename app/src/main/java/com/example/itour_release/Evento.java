package com.example.itour_release;

public class Evento {

    private String nombre;
    private String fecha;
    private String departamento;

    public Evento(String nombre, String fecha, String departamento) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
