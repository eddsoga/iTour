package com.example.itour_release;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Ubicaciones extends AppCompatActivity {


    String imagenViewID;
    ImageView imagenview;
    int imageID;
    String drawable;
    int idDrawable;
    String textViewID;
    int resID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);

        List<LocationItem> locationList = LocationItemList.getLocationList();

        for (int i = 0; i < locationList.size(); i++) {
            ImageView imageView = findViewById(getResources().getIdentifier("imageView" + (i + 1), "id", getPackageName()));
            TextView textView = findViewById(getResources().getIdentifier("textView" + (i + 1), "id", getPackageName()));

            if (imageView != null && textView != null) {
                LocationItem locationItem = locationList.get(i);
                String nombreEdificio = locationItem.getTitle();
                String rutaImagen = locationItem.getRutaImagen();

                try {
                    int idDrawable = getResources().getIdentifier(rutaImagen, "drawable", getPackageName());
                    imageView.setImageResource(idDrawable);
                    imageView.setClipToOutline(true);

                    textView.setText(nombreEdificio);
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    textView.setTextSize(18);
                    textView.setTypeface(null, Typeface.BOLD);

                    // Set click listener for the TextView
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.putExtra("tituloMostrar", nombreEdificio);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.putExtra("tituloMostrar", nombreEdificio);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    });


                } catch (Exception e) {
                    Toast.makeText(this, "Error al cargar imagen o texto: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }





    //Regresar al Mapa

    public void Mapa(View view){
        finish();
    }


    public void Click(View view){
        //Función para abrir la interfaz de detalles de la
        //Intent intent = new Intent(getApplicationContext(), Detalles.class);
        //startActivity(intent);

    }


}