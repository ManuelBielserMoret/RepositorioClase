package com.example.practica_5_listas;

import android.widget.TextView;
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
}
