package com.eduardorascon.gasolina.pojos;

public class PrecioGasolina {
    private String nombreDeRegion;
    private int numeroDeRegion;

    public PrecioGasolina() {
    }

    public PrecioGasolina(String nombreDeRegion, int numeroDeRegion){
        this.nombreDeRegion = nombreDeRegion;
        this.numeroDeRegion = numeroDeRegion;
    }

    public String getNombreDeRegion() {
        return nombreDeRegion;
    }

    public void setNombreDeRegion(String nombreDeRegion) {
        this.nombreDeRegion = nombreDeRegion;
    }

    public int getNumeroDeRegion() {
        return numeroDeRegion;
    }

    public void setNumeroDeRegion(int numeroDeRegion) {
        this.numeroDeRegion = numeroDeRegion;
    }
}
