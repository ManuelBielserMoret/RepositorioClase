package com.example.practica_5_listas;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
public class AdaptadorAnimales extends RecyclerView.Adapter<AdaptadorAnimales.ViewHolder>{
    private Animales[] listaAnimales;
    public AdaptadorAnimales (Animales[] listaAnimales) {
        this.listaAnimales = listaAnimales;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre;
        public TextView textViewRaza;
        public TextView textViewEdad;
        public ViewHolder(View view) {
            super(view);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewRaza = view.findViewById(R.id.textViewRaza);
            textViewEdad = view.findViewById(R.id.textViewEdad);
        }
        public void BindAnimal(Animales animal) {
            textViewNombre.setText(animal.getNombre());
            textViewRaza.setText(animal.getRaza());
            textViewEdad.setText(String.valueOf(animal.getEdad()));
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.BindAnimal(this.listaAnimales[position]);
    }
    @Override
    public int getItemCount() {
        return this.listaAnimales.length;
    }
}
