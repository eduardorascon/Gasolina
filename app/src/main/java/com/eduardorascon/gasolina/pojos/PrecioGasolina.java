package com.eduardorascon.gasolina.pojos;

public class PrecioGasolina {
    private String numeroDeRegion, nombreDeRegion, estado, municipio;
    private String verde, roja, diesel;

    public PrecioGasolina() {
    }

    public PrecioGasolina(String nombreDeRegion, String numeroDeRegion, String estado, String municipio) {
        this.numeroDeRegion = numeroDeRegion;
        this.nombreDeRegion = nombreDeRegion;
        this.estado = estado;
        this.municipio = municipio;
    }

    public String getNombreDeRegion() {
        return nombreDeRegion;
    }

    public void setNombreDeRegion(String nombreDeRegion) {
        this.nombreDeRegion = nombreDeRegion;
    }

    public String getNumeroDeRegion() {
        return numeroDeRegion;
    }

    public void setNumeroDeRegion(String numeroDeRegion) {
        this.numeroDeRegion = numeroDeRegion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
