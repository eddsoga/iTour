package com.example.itour_release;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.model.LatLng;

public class InformacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Obtener el objeto LocationItem del intent
            LocationItem locationItem = getIntent().getParcelableExtra("locationItem");

            // Ahora puedes acceder a todas las propiedades del objeto LocationItem
            String nombre = locationItem.getTitle();
            String descripcion = locationItem.getDescription();
            String tipoUbicacion = locationItem.getLocationType();
            LatLng coordenadas = locationItem.getPosition();
            int iconResourceId = locationItem.getIconResourceId();
            String rutaImagen = locationItem.getRutaImagen();
            // Y así sucesivamente...

            // Mostrar los datos en la interfaz de usuario, por ejemplo:
            TextView tvNombre = findViewById(R.id.tvNombre);
            TextView tvCoordenadas = findViewById(R.id.tvCoordenadas);
            TextView tvDescripcion = findViewById(R.id.tvDescripcion);
            TextView tvTipoUbicacion = findViewById(R.id.tvTipoUbicacion);
            ImageView ivIcono = findViewById(R.id.ivIcono);
            ImageView ivRuta = findViewById(R.id.ivRuta);

            tvNombre.setText(nombre);
            tvCoordenadas.setText("Coordenadas: " + coordenadas.latitude + ", " + coordenadas.longitude);
            tvDescripcion.setText("Descripción:\n" + descripcion);
            tvTipoUbicacion.setText("Tipo:"+tipoUbicacion);
            ivIcono.setImageResource(iconResourceId);
            int img2 = getResources().getIdentifier(rutaImagen, "drawable", getPackageName());
            ivRuta.setImageResource(img2);



            return insets;


        });
    }
    public void goBack(View view) {
        finish(); // Finaliza la actividad actual y regresa a la actividad anterior
    }

}