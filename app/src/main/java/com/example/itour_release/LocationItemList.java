package com.example.itour_release;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class LocationItemList {
    private static List<LocationItem> locationList = new ArrayList<>();

    static {
        // Agrega todas tus ubicaciones aquí
        locationList.add(new LocationItem(new LatLng(17.078413, -96.745638), "Edificio A", R.drawable.school,"","","edi_a"));
        locationList.add(new LocationItem(new LatLng(17.078253, -96.744824), "Edificio B", R.drawable.school,"","","edi_b"));
        locationList.add(new LocationItem(new LatLng(17.0780357, -96.744878), "Edificio C", R.drawable.school,"","","edi_c"));
        locationList.add(new LocationItem(new LatLng(17.077242, -96.743530), "Edificio D", R.drawable.school,"","","edi_quimica"));
        locationList.add(new LocationItem(new LatLng(17.076978, -96.744072), "Edificio E", R.drawable.school,"","","edi_e")); //Edicio Ing.Quimica
        locationList.add(new LocationItem(new LatLng(17.078679, -96.743775), "Edificio Electrónica", R.drawable.school,"","","edi_electronica"));
        locationList.add(new LocationItem(new LatLng(17.076693, -96.744116), "Edificio F", R.drawable.school,"","","edi_f"));
        locationList.add(new LocationItem(new LatLng(17.076471, -96.744178), "Edificio G", R.drawable.school,"","","edi_g"));
        locationList.add(new LocationItem(new LatLng(17.0760628, -96.7447535), "Edificio I", R.drawable.school,"","","edi_i"));
        locationList.add(new LocationItem(new LatLng(17.0762137, -96.74452380), "Edificio J", R.drawable.school,"","","edi_j"));
        locationList.add(new LocationItem(new LatLng(17.078134, -96.744110), "Edificio L", R.drawable.school,"","","civil")); //Edificio Ing. Civil
        locationList.add(new LocationItem(new LatLng(17.077692, -96.743639), "Gimnacio ITO", R.drawable.dumbbell,"","","gym_ito"));
        locationList.add(new LocationItem(new LatLng(17.077711, -96.744199), "Centro de Información - Biblioteca", R.drawable.book,"","Lugar donde los estudiantes realizan actividades de caracter informatico","biblio"));
        locationList.add(new LocationItem(new LatLng(17.079001, -96.744982), "Laboratorio 1: Ing. Electrónica", R.drawable.tube,"","","lab_electrica"));
        locationList.add(new LocationItem(new LatLng(17.079258, -96.744811), "Laboratorio 2: Simulación", R.drawable.pc,"","","lab_sim1"));
        locationList.add(new LocationItem(new LatLng(17.078576, -96.744589), "Laboratorio 3: Ing. Química", R.drawable.tube,"","","lb_quimica_bioquimica"));
        locationList.add(new LocationItem(new LatLng(17.078721, -96.744533), "Laboratorio 4: Ing. Mecánica", R.drawable.tube,"","","lab_ing_mecanica"));
        locationList.add(new LocationItem(new LatLng(17.077990, -96.744427), "Laboratorio 5: Ing. Química", R.drawable.tube,"","","lab_quimica_analitica2"));
        locationList.add(new LocationItem(new LatLng(17.078653, -96.7443106), "Laboratorio 6: Ing. Civil", R.drawable.tube,"","","lab_civil"));
        locationList.add(new LocationItem(new LatLng(17.079082, -96.744324), "Centro de Cómputo: Laboratorio 7", R.drawable.pc,"","","centro_computo"));
        locationList.add(new LocationItem(new LatLng(17.079408, -96.743909), "Laboratorio 8: Ing. Química", R.drawable.tube,"","","lab_ing_mecanica"));
        locationList.add(new LocationItem(new LatLng(17.078784, -96.743807), "Laboratorio 9: Ing. Electrónica", R.drawable.tube,"","","lab_ing_indus"));
        locationList.add(new LocationItem(new LatLng(17.078233, -96.745259), "Sala de Titulación", R.drawable.hat,"","","sala_titulacion"));
        locationList.add(new LocationItem(new LatLng(17.077187, -96.744013), "Cafeteria", R.drawable.cafe,"","","cafe_izq"));
        locationList.add(new LocationItem(new LatLng(17.077804, -96.746049), "Estacionamiento 1", R.drawable.park,"","","parking"));
        locationList.add(new LocationItem(new LatLng(17.075941, -96.744244), "Estacionamiento 2", R.drawable.park,"","","parking"));
        locationList.add(new LocationItem(new LatLng(17.076591, -96.745322), "Estacionamiento 3", R.drawable.park,"","","parking"));
        locationList.add(new LocationItem(new LatLng(17.077209, -96.7440196), "Cafeteria", R.drawable.cafe,"","","cafe_izq"));

        // Agrega el resto de ubicaciones aquí
    }

    public static List<LocationItem> getLocationList() {
        return locationList;
    }
}
