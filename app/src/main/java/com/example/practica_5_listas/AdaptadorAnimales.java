package com.example.practica_5_listas;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class AdaptadorAnimales  extends RecyclerView.Adapter<AdaptadorAnimales.ViewHolder>{
    private animales[] listaAnimales;
    public AdaptadorAnimales (animales[] listaAnimales) {
        this.listaAnimales = listaAnimales;

    }
}
