package com.eduardorascon.gasolina.sqlite;

public class Municipio {
    private int id;
    private String municipio, estado, region;

    public Municipio(){
    }

    public Municipio(int id, String municipio, String estado, String region) {
        this.id = id;
        this.municipio = municipio;
        this.estado = estado;
        this.region = region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}