package com.example.itour_release;

import android.app.Application;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static MyApplication singleton;

    public List<Location> getMyLocations() {
        return myLocations;
    }

    public void setMyLocations(List<Location> myLocations) {
        this.myLocations = myLocations;
    }

    private List <Location> myLocations;

    private String nDestino;

    private LatLng miDestino;

    public MyApplication getInstance(){
        return singleton;
    }

    public void onCreate(){
        super.onCreate();
        singleton= this;
        myLocations= new ArrayList<>();
        miDestino=new LatLng(0.0,0.0);
        nDestino=new String("");
    }
    public LatLng getMiDestino() {
        return miDestino;
    }

    public void setMiDestino(LatLng miDestino) {
        this.miDestino = miDestino;
    }

    public String getnDestino() {
        return nDestino;
    }

    public void setnDestino(String nDestino) {
        this.nDestino = nDestino;
    }

}