package com.example.itour_release;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.itour_release.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_UBICACIONES = 1;
    private static final int PERMISSIONS_FINE_LOCATION = 1001; // Definir constante directamente
    private static final float DEFAULT_ZOOM = 15f;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private Location currentLocation, mLastKnownLocation;
    private LocationCallback locationCallback;
    private MyApplication aplicacion;

    private List<Marker> markerList = new ArrayList<>();
    private LocationItem destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicialización
        aplicacion = (MyApplication) getApplicationContext();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        // Configurar mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        //config boton python
        Button myButton = findViewById(R.id.botonPython);
        //Inicializar Python
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }


        // Configurar FAB para animar la cámara
        binding.btnIto.setOnClickListener(v -> animateCameraToDefaultLocation());
    }

    /**
     * Solicitar permisos de ubicación y obtener la ubicación actual.
     */
    private void updateGPS() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, location -> currentLocation = location);
        } else {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
        }
    }

    /**
     * Abrir actividades relacionadas.
     */
    public void openLista(View view) {
        startActivityForResult(new Intent(this, Ubicaciones.class), REQUEST_CODE_UBICACIONES);
    }

    public void openEventos(View view) {
        startActivity(new Intent(this, Eventos.class));
    }

    public void openCalendario(View view) {
        startActivity(new Intent(this, Calendar_Activity.class));
    }

    public void correrPyhton(View view) {
        // Inicializar Python
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("show_alert");

        // Llamar a una función de Python y mostrar el resultado en un Toast
        String mensaje = pythonFile.callAttr("show_toast").toString();
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Manejar el mapa una vez que está listo.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Configurar mapa y cargar marcadores
        cargarMarcadores();
        centrarMapa();

        // Listener para los clics en los marcadores
        mMap.setOnMarkerClickListener(marker -> {
            LocationItem locationItem = obtenerLocationItem(marker.getPosition(), marker.getTitle());
            if (locationItem != null) {
                // Abrir el popup con la información del marcador
                Intent intent = new Intent(getApplicationContext(), PopActivity.class);
                intent.putExtra("locationItem", locationItem);
                startActivityForResult(intent, 1);
            } else {
                Toast.makeText(this, "No se encontró información para este marcador.", Toast.LENGTH_SHORT).show();
            }
            return true; // Indica que se manejó el evento de clic
        });

        configurarUIMapa();

        // Aplicar estilo de mapa (día o noche)
        aplicarEstiloMapa();
    }

    // Refactor: Metodo para cargar los marcadores en el mapa
    private void cargarMarcadores() {
        List<LocationItem> locationList = LocationItemList.getLocationList();
        for (LocationItem item : locationList) {
            agregarMarcador(item);
        }
    }

    // Refactor: Metodo para centrar el mapa según el destino configurado
    private void centrarMapa() {
        LatLng destino = aplicacion.getMiDestino();
        if (destino.longitude == 0.0) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(17.077711, -96.744199), 18.0f));
        } else {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(destino, 19.0f));
            agregarMarcador(destino, "Marcador Destino", R.drawable.marcador);
        }
    }

    // Refactor: Metodo para configurar la interfaz de usuario del mapa
    private void configurarUIMapa() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }

    // Refactor:Metodo para aplicar el estilo de mapa (día o noche)
    private void aplicarEstiloMapa() {
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.night));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.day));
                break;
        }
    }

    // Refactor: Metodo para agregar un marcador generico
    private void agregarMarcador(LocationItem item) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(item.getPosition())
                .title(item.getTitle())
                .icon(BitmapDescriptorFactory.fromResource(item.getIconResourceId()));
        Marker marker = mMap.addMarker(markerOptions);
        markerList.add(marker); // Guardar el marcador en la lista
    }

    // Metodo para agregar un marcador perzonalizado

    private void agregarMarcador(LatLng position, String title, int iconResourceId) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(position)
                .title(title)
                .icon(BitmapDescriptorFactory.fromResource(iconResourceId));
        mMap.addMarker(markerOptions).showInfoWindow();
    }

    // Refactor:Metodo para obtener un LocationItem con base en la posición y el título del marcador
    private LocationItem obtenerLocationItem(LatLng position, String title) {
        List<LocationItem> locationList = LocationItemList.getLocationList();
        for (LocationItem item : locationList) {
            if (item.getPosition().equals(position) && item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Animar la cámara a la ubicación predeterminada.
     */
    private void animateCameraToDefaultLocation() {
        LatLng defaultLocation = new LatLng(17.077711, -96.744199);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_UBICACIONES && resultCode == RESULT_OK && data != null) {
            handleActivityResult(data);
        }
    }
    /**
     * Manejar el resultado de una actividad.
     */
    private void handleActivityResult(Intent data) {
        String titulo = data.getStringExtra("tituloMostrar");
        if (titulo == null) return;

        for (LocationItem item : LocationItemList.getLocationList()) {
            if (item.getTitle().equals(titulo)) {
                destino = item;
                break;
            }
        }

        if (destino != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destino.getPosition(), 18));
            for (Marker marker : markerList) {
                if (marker.getPosition().equals(destino.getPosition()) && marker.getTitle().equals(destino.getTitle())) {
                    marker.showInfoWindow();
                    break;
                }
            }
        }
    }
}
