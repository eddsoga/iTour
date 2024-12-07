package com.example.itour_release;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;


public class LocationItem implements Parcelable {
    private LatLng position; //Coordenadas de la ubicación
    private String title; //Nombre de la ubicación
    private int iconResourceId; //ID del recurso de ícono
    private String locationType; //Tipo de ubicación
    private String description; //Descripción de la ubicación
    private String rutaImagen;

    public LocationItem(LatLng position, String title, int iconResourceId, String locationType,String description, String rutaImagen) {
        this.position = position;
        this.title = title;
        this.iconResourceId = iconResourceId;
        if (locationType == null) {
            this.locationType = "default";
        } else {
            this.locationType = locationType;
        }
        if (description == null) {
            this.description = "";
        } else {
            this.description = description;
        }
        if (rutaImagen == null) {
            this.rutaImagen = "x";
        } else {
            this.rutaImagen = rutaImagen;
        }
    }

    protected LocationItem(Parcel in) {
        position = in.readParcelable(LatLng.class.getClassLoader());
        title = in.readString();
        iconResourceId = in.readInt();
        locationType = in.readString();
        description = in.readString();
        rutaImagen = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(position, flags);
        dest.writeString(title);
        dest.writeInt(iconResourceId);
        dest.writeString(locationType);
        dest.writeString(description);
        dest.writeString(rutaImagen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocationItem> CREATOR = new Creator<LocationItem>() {
        @Override
        public LocationItem createFromParcel(Parcel in) {
            return new LocationItem(in);
        }

        @Override
        public LocationItem[] newArray(int size) {
            return new LocationItem[size];
        }
    };

    public LatLng getPosition() {
        return position;
    }
    public void setPosition(LatLng position) {
        this.position = position;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getIconResourceId() {
        return iconResourceId;
    }
    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }
    public String getLocationType() {return locationType;}
    public void setLocationType(String locationType) {this.locationType = locationType;}
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}
    public String getRutaImagen() {return rutaImagen;}
    public void setRutaImagen(String rutaImagen) {this.rutaImagen = rutaImagen;}

}