package com.eduardorascon.gasolina.pojos;

import android.support.v7.widget.util.SortedListAdapterCallback;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

public class PrecioGasolina implements SortedListAdapter.ViewModel {
    private final String numeroDeRegion, nombreDeRegion, estado, municipio;
    private final String verde, roja, diesel;

    public PrecioGasolina(String nombreDeRegion, String numeroDeRegion, String estado, String municipio, String verde, String roja, String diesel) {
        this.numeroDeRegion = numeroDeRegion;
        this.nombreDeRegion = nombreDeRegion;
        this.estado = estado;
        this.municipio = municipio;
        this.verde = verde;
        this.roja = roja;
        this.diesel = diesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrecioGasolina that = (PrecioGasolina) o;

        if (!numeroDeRegion.equals(that.numeroDeRegion)) return false;
        if (!nombreDeRegion.equals(that.nombreDeRegion)) return false;
        if (!estado.equals(that.estado)) return false;
        return municipio.equals(that.municipio);

    }

    @Override
    public int hashCode() {
        int result = numeroDeRegion.hashCode();
        result = 31 * result + nombreDeRegion.hashCode();
        result = 31 * result + estado.hashCode();
        result = 31 * result + municipio.hashCode();
        return result;
    }

    public String getNombreDeRegion() {
        return nombreDeRegion;
    }

    public String getNumeroDeRegion() {
        return numeroDeRegion;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getVerde() {
        return verde;
    }

    public String getRoja() {
        return roja;
    }

    public String getDiesel() {
        return diesel;
    }

}