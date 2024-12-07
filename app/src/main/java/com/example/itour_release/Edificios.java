package com.example.itour_release;

import com.google.android.gms.maps.model.LatLng;

public class Edificios {
    LatLng ubi;
    String nombre;
    String descripcion;
    String ruta;

    public Edificios(String nombre, LatLng ubi, String descripcion, String ruta){
       this.ubi=ubi;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.ruta=ruta;
    }
    public LatLng getUbi() {
        return ubi;
    }

    public void setUbi(LatLng ubi) {
        this.ubi = ubi;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setRuta(String ruta){
        this.ruta=ruta;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getRuta(){
        return ruta;
    }

}