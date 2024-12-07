package com.example.itour_release;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private List<Evento> mData;
    private LayoutInflater mInflater;
    private Context context;

    public EventListAdapter(List<Evento> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.event_element, null);
        return new EventListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Evento> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, fecha, departamento;


        ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.text_event_name);
            fecha = itemView.findViewById(R.id.text_event_date);
            departamento = itemView.findViewById(R.id.text_event_department);
        }

        void bindData(final Evento item) {
            nombre.setText(item.getNombre());
            fecha.setText(item.getFecha());
            departamento.setText(item.getDepartamento());
        }
    }
}
