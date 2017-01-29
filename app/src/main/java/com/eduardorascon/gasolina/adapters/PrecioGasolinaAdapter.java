package com.eduardorascon.gasolina.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.eduardorascon.gasolina.R;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;

import java.util.List;

public class PrecioGasolinaAdapter extends RecyclerView.Adapter<PrecioGasolinaAdapter.PrecioViewHolder> {
    private List<PrecioGasolina> listaDePrecios;

    public PrecioGasolinaAdapter(List<PrecioGasolina> listaDePrecios) {
        this.listaDePrecios = listaDePrecios;
    }

    public class PrecioViewHolder extends RecyclerView.ViewHolder {
        TextView region, estado, municipio, verde, roja, diesel;
        ToggleButton toggleButton;

        public PrecioViewHolder(View view) {
            super(view);
            //region = (TextView) view.findViewById(R.id.textView2);
            estado = (TextView) view.findViewById(R.id.textView3);
            municipio = (TextView) view.findViewById(R.id.textView4);
            verde = (TextView) view.findViewById(R.id.textView5);
            roja = (TextView) view.findViewById(R.id.textView6);
            diesel = (TextView) view.findViewById(R.id.textView7);

            toggleButton = (ToggleButton) view.findViewById(R.id.toggle);
            toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("CLICK", toggleButton.isChecked() ? "ON" : "OFF");
                }
            });
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
        //holder.region.setText("REGION " + precio.getNombreDeRegion() + " - " + precio.getNumeroDeRegion());
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