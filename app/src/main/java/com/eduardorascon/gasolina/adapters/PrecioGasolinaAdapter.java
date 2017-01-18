package com.eduardorascon.gasolina.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;

import java.util.List;

public class PrecioGasolinaAdapter extends RecyclerView.Adapter<PrecioGasolinaAdapter.MyViewHolder> {
    private List<PrecioGasolina> listaDePrecios;

    public PrecioGasolinaAdapter(List<PrecioGasolina> listaDePrecios) {
        this.listaDePrecios = listaDePrecios;
    }

    @Override
    public PrecioGasolinaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview_precio_gasolina, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrecioGasolinaAdapter.MyViewHolder holder, int position) {
        PrecioGasolina precio = listaDePrecios.get(position);
        holder.region.setText(precio.getNombreDeRegion() + " - " + precio.getNumeroDeRegion());
        holder.estado.setText(precio.getEstado());
        holder.municipio.setText(precio.getMunicipio());
    }

    @Override
    public int getItemCount() {
        return listaDePrecios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView region, estado, municipio;

        public MyViewHolder(View view) {
            super(view);
            region = (TextView) view.findViewById(R.id.textView2);
            estado = (TextView) view.findViewById(R.id.textView3);
            municipio=(TextView) view.findViewById(R.id.textView4);
        }
    }
}