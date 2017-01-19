package com.eduardorascon.gasolina.pojos;

public class PrecioGasolina {
    private String numeroDeRegion, nombreDeRegion, estado, municipio;
    private String verde, roja, diesel;

    public PrecioGasolina() {
    }

    public PrecioGasolina(String nombreDeRegion, String numeroDeRegion, String estado, String municipio, String verde, String roja, String diesel) {
        this.numeroDeRegion = numeroDeRegion;
        this.nombreDeRegion = nombreDeRegion;
        this.estado = estado;
        this.municipio = municipio;
        this.verde = verde;
        this.roja = roja;
        this.diesel = diesel;
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
