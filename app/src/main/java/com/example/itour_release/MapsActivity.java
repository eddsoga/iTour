package com.example.itour_release;

import static com.example.itour_release.MainActivity.PERMISSIONS_FINE_LOCATION;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

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
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_UBICACIONES = 1;
    private View mapView;
    private final float DEFAULT_ZOOM = 15;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LocationItem destino;
    FusedLocationProviderClient fusedLocationProviderClient, mFusedLocationProviderClient;
    Location currentLocation, mLastKnownLocation;

    LocationCallback locationCallback;
    FloatingActionButton fAB;
    MyApplication aplicacion;

    private List<Marker> markerList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fAB = findViewById(R.id.btn_ito);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        aplicacion = (MyApplication) getApplicationContext();

        // Inicializar el FusedLocationProviderClient

    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private void updateGPS() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MapsActivity.this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    currentLocation = location;
                }
            });
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
            }
        }
    }
    public void Lista(View view){
        Intent intent = new Intent(getApplicationContext(), Ubicaciones.class);
        startActivityForResult(intent, REQUEST_CODE_UBICACIONES);
    }

    //Metodo para abrir activity de eventos
    public void Eventos(View view){
        Intent intent = new Intent(getApplicationContext(), Eventos.class);
        startActivity(intent);
    }

    public void Calendario(View view){
        Intent intent = new Intent(getApplicationContext(), Calendar_Activity.class);
        startActivity(intent);
    }
    private Marker addMarker(GoogleMap map, LatLng position, String title, int iconResourceId) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position);
        markerOptions.title(title);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(iconResourceId));
        Marker marker = map.addMarker(markerOptions);
        markerList.add(marker);
        return marker;
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        List<LocationItem> locationList = LocationItemList.getLocationList();
        for (LocationItem item : locationList) {
            addMarker(mMap, item.getPosition(), item.getTitle(), item.getIconResourceId());
        }


        // Agrega los demás marcadores aquí

        if(aplicacion.getMiDestino().longitude==0.0){
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(17.077711, -96.744199), 18.0f));

        }else{
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(aplicacion.getMiDestino(), 19.0f));
            MarkerOptions markerOptions=new MarkerOptions();
            markerOptions.position(aplicacion.getMiDestino());
            markerOptions.title("Marcador Destino");
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador));
            markerOptions.zIndex(0.0f);
            mMap.addMarker(markerOptions).showInfoWindow();
        }



        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                // Obtener la información de la ubicación desde LocationItemList
                LocationItem locationItem = getLocationItemFromList(marker.getPosition(), marker.getTitle());

                if (locationItem != null) {
                    // Crear un intent y adjuntar la información de la ubicación
                    Intent intent = new Intent(getApplicationContext(), PopActivity.class);
                    intent.putExtra("locationItem", locationItem);
                    startActivityForResult(intent, 1);
                }

                return false;
            }
        });

        fAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(17.077711, -96.744199), 17.0f));
            }
        });

        //FIN MI CODIGO
        if (mapView != null && mapView.findViewById(Integer.parseInt("1")) != null) {
            View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();

            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.setMargins(0, 0, 0, 0);
        }

        //Map Settings
        mMap.setMapType(1); //2 es satelite
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);






        //DARK MODE
        int nightModeFlags =
                this.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                mMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.night));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                mMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.day));
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:

                break;
        }



    }
    private LocationItem getLocationItemFromList(LatLng position, String title) {
        List<LocationItem> locationList = LocationItemList.getLocationList();
        for (LocationItem item : locationList) {
            if (item.getPosition().equals(position) && item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    @SuppressLint("MissingPermission")
    private void getDeviceLocation() {
        mFusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnownLocation = task.getResult();
                            if (mLastKnownLocation != null) {
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            } else {
                                final LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback() {
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if (locationResult == null) {
                                            return;
                                        }
                                        mLastKnownLocation = locationResult.getLastLocation();
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                                        mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
                                    }
                                };
                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);

                            }
                        } else {
                            Toast.makeText(MapsActivity.this, "unable to get last location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String titulo = data.getStringExtra("tituloMostrar");
            assert titulo != null;
            for (LocationItem item : LocationItemList.getLocationList()) {
                if (item.getTitle().equals(titulo)) {
                    destino = item;
                    break;
                }
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destino.getPosition(), 18));
            if (destino != null) {
                // Buscar el marcador correspondiente y mostrar su ventana de información
                for (Marker marker : markerList) {
                    if (marker.getPosition().equals(destino.getPosition()) && marker.getTitle().equals(destino.getTitle())) {
                        marker.showInfoWindow(); // Aquí se muestra la ventana de información del marcador
                        break;
                    }
                }
            }
        }
    }
}


