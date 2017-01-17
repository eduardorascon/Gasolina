package com.eduardorascon.gasolina.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;

import org.w3c.dom.Text;

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
        holder.region.setText(precio.getNumeroDeRegion());
        holder.nombre.setText(precio.getNombreDeRegion());
    }

    @Override
    public int getItemCount() {
        return listaDePrecios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, region;

        public MyViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.textView2);
            region = (TextView) view.findViewById(R.id.textView3);
        }
    }
}