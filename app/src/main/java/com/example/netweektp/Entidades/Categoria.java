package com.example.netweektp.Entidades;

public class Categoria {
    public int getIdCat() {
        return IdCat;
    }

    public void setIdCat(int idCat) {
        IdCat = idCat;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(int habilitado) {
        Habilitado = habilitado;
    }

    private int IdCat ;
    private String Nombre;
    private int Habilitado;


}
