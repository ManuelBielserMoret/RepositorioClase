package com.example.practica_5_listas;

public class Animales {
    private String nombre;
    private String raza;
    private int edad;

    public Animales (String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRaza() {
        return raza;
    }
    public int getEdad() {
        return edad;
    }
}
