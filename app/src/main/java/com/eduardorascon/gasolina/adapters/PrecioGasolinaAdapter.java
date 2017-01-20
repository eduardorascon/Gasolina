package com.eduardorascon.gasolina.adapters;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.List;

public class PrecioGasolinaAdapter extends RecyclerView.Adapter<PrecioGasolinaAdapter.PrecioViewHolder> {
    private List<PrecioGasolina> listaDePrecios;

    public PrecioGasolinaAdapter(List<PrecioGasolina> listaDePrecios) {
        this.listaDePrecios = listaDePrecios;
    }

    public class PrecioViewHolder extends SortedListAdapter.ViewHolder<PrecioGasolina> {
        public TextView region, estado, municipio, verde, roja, diesel;

        public PrecioViewHolder(View view) {
            super(view);
            region = (TextView) view.findViewById(R.id.textView2);
            estado = (TextView) view.findViewById(R.id.textView3);
            municipio = (TextView) view.findViewById(R.id.textView4);
            verde = (TextView) view.findViewById(R.id.textView5);
            roja = (TextView) view.findViewById(R.id.textView6);
            diesel = (TextView) view.findViewById(R.id.textView7);
        }

        @Override
        protected void performBind(PrecioGasolina precioGasolina) {

        }
    }

    @Override
    public PrecioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview_precio_gasolina, parent, false);
        return new PrecioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrecioViewHolder holder, int position) {
        PrecioGasolina precio = listaDePrecios.get(position);
        holder.region.setText("REGION " + precio.getNombreDeRegion() + " - " + precio.getNumeroDeRegion());
        holder.estado.setText(precio.getEstado());
        holder.municipio.setText(precio.getMunicipio());
        holder.verde.setText(precio.getVerde());
        holder.roja.setText(precio.getRoja());
        holder.diesel.setText(precio.getDiesel());
    }

    @Override
    public int getItemCount() {
        return listaDePrecios.size();
    }
}