package com.eduardorascon.gasolina.sqlite;

public class Municipio {
    private int id;
    private String municipio, estado;
    private boolean isFavorited = false;
    private String verde, roja, diesel;

    public Municipio() {
    }

    public Municipio(int id, String municipio, String estado, String verde, String roja, String diesel) {
        this.id = id;
        this.municipio = municipio;
        this.estado = estado;
        this.verde = verde;
        this.roja = roja;
        this.diesel = diesel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public String getVerde() {
        return verde;
    }

    public void setVerde(String verde) {
        this.verde = verde;
    }

    public String getRoja() {
        return roja;
    }

    public void setRoja(String roja) {
        this.roja = roja;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }
}