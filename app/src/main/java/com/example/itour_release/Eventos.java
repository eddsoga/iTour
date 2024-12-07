package com.example.itour_release;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Eventos extends AppCompatActivity {

    private ArrayList<Evento> eventos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        eventos = llenarLista();
        EventListAdapter listAdapter = new EventListAdapter(eventos, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private ArrayList<Evento> llenarLista(){
        ArrayList<Evento> e = new ArrayList<>();
        e.add(new Evento("Solicitud para cambio de carrera", "06 al 13 de mayo", "División de estudios profesionales"));
        e.add(new Evento("Evaluación docente", "06 al 17 de mayo", "División de estudios profesionales"));
        e.add(new Evento("Día de las madres", "10 de mayo", "Comunicación y difusión"));
        e.add(new Evento("Día del trabajador de la educación", "15 de mayo", "Comunicación y difusión"));
        e.add(new Evento("Pláticas de inducción al servicio social", "20 al 28 de mayo", "Gestión tecnológica y vinculación"));
        e.add(new Evento("Examen para cambio de carrera", "24 de mayo", "Desarrollo académico"));
        e.add(new Evento("Entrega de tercer reporte parcial de gestión de curso", "27 al 31 de mayo", "Departamentos académicos"));
        e.add(new Evento("Fin de cursos", "31 de mayo", ""));

        return e;
    }
    public void goBack(View view) {
        finish(); // Finaliza la actividad actual y regresa a la actividad anterior
    }
}