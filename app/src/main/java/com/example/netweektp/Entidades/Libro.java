package com.example.netweektp.Entidades;

import java.sql.Date;

public class Libro {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaEdicion() {
        return FechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        FechaEdicion = fechaEdicion;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }


    public int getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        Id_Categoria = id_Categoria;
    }
    public int getEnStock() {
        return EnStock;
    }

    public void setEnStock(int enStock) {
        EnStock = enStock;
    }
    private String Nombre;
    private Date FechaEdicion;
    private String Editorial;
    private int EnStock;
    private int Id_Categoria;

}
