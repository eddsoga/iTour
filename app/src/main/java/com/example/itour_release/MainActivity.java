package com.example.itour_release;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_FINE_LOCATION = 99;

    private Location currentLocation;
    private List<Location> savedLocations;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Button btnGrant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        btnGrant = findViewById(R.id.btn_Grant);

        // Configurar LocationRequest
        setupLocationRequest();

        // Configurar callback de ubicación
        setupLocationCallback();

        // Comprobar permisos y proceder
        checkPermissions();

        // Configurar botón para iniciar MapsActivity
        btnGrant.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
        });
    }

    private void setupLocationRequest() {
        locationRequest = LocationRequest.create()
                .setInterval(30000) // 30 segundos
                .setFastestInterval(5000) // 5 segundos
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    private void setupLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult != null && !locationResult.getLocations().isEmpty()) {
                    currentLocation = locationResult.getLastLocation();
                }
            }
        };
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            proceedToMapsActivity();
        } else {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
        }
    }

    private void proceedToMapsActivity() {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // Llamar a la implementación base
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                proceedToMapsActivity();
            } else {
                showPermissionRationale();
            }
        }
    }

    private void showPermissionRationale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            new AlertDialog.Builder(this)
                    .setTitle("Permisos Necesarios")
                    .setMessage("La aplicación requiere permisos de ubicación para funcionar. Por favor actívelos.")
                    .setPositiveButton("OK", (dialog, which) -> {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    })
                    .setNegativeButton("Cancelar", (dialog, which) -> finish())
                    .show();
        }
    }
}
