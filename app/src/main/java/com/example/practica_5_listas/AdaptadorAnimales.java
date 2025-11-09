package com.example.practica_5_listas;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class AdaptadorAnimales  extends RecyclerView.Adapter<AdaptadorAnimales.ViewHolder>{
    private Animales[] listaAnimales;
    public AdaptadorAnimales (Animales[] listaAnimales) {
        this.listaAnimales = listaAnimales;

    }
}
