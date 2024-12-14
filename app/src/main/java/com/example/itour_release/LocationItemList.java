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
        // Lista de intersecciones
        locationList.add(new LocationItem(new LatLng(17.076439, -96.744914), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076326, -96.744487), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076649, -96.744375), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076735, -96.744356), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076480, -96.743916), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076693, -96.743817), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076901, -96.744877), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077141, -96.744809), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077200, -96.744939), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077093, -96.744625), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077004, -96.744378), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076877, -96.743984), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076704, -96.743834), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076852, -96.744300), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076945, -96.744258), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.076999, -96.744376), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077014, -96.743700), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077167, -96.743798), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077195, -96.743908), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077340, -96.743871), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077436, -96.744180), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077394, -96.744004), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077406, -96.743729), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077502, -96.743966), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077885, -96.743857), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078166, -96.743776), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078038, -96.744327), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078282, -96.744092), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078729, -96.743959), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078334, -96.744234), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078876, -96.744415), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.079218, -96.744147), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078986, -96.744815), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078848, -96.744848), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078492, -96.744959), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078376, -96.745020), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078410, -96.745119), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078461, -96.745286), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078901, -96.745159), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078306, -96.745147), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078144, -96.744658), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078052, -96.744681), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077861, -96.744752), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078006, -96.745238), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078071, -96.745471), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077769, -96.745683), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.077616, -96.745855), "Intersección", R.drawable.interseccion,"","",""));
        locationList.add(new LocationItem(new LatLng(17.078383, -96.745914), "Intersección", R.drawable.interseccion,"","",""));


        locationList.add(new LocationItem(new LatLng(17.076757, -96.744942), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.075572, -96.744810), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076482, -96.745068), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076385, -96.745089), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076339, -96.745111), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076156, -96.745153), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076014, -96.744876), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.075777, -96.744754), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.077020, -96.743952), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.078208, -96.745182), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.078369, -96.744597), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.078835, -96.744264), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.077341, -96.745687), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.077346, -96.745688), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076939, -96.745454), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.077477, -96.744869), "Intersección", R.drawable.interseccion, "", "", ""));
        locationList.add(new LocationItem(new LatLng(17.076268, -96.744850), "Intersección", R.drawable.interseccion, "","", ""));
        locationList.add(new LocationItem(new LatLng(17.077605, -96.744818), "Intersección", R.drawable.interseccion, "","", ""));
        locationList.add(new LocationItem(new LatLng(17.077466, -96.744389), "Intersección", R.drawable.interseccion, "","", ""));
        locationList.add(new LocationItem(new LatLng(17.077789, -96.744415), "Intersección", R.drawable.interseccion, "","", ""));


    }

    public static List<LocationItem> getLocationList() {
        return locationList;
    }
}
