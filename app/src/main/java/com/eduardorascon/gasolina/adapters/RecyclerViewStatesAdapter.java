package com.eduardorascon.gasolina.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;

import java.util.ArrayList;

public class RecyclerViewStatesAdapter extends RecyclerView.Adapter<RecyclerViewStatesAdapter.ViewHolder> {
    private ArrayList<String> statesList;

    public RecyclerViewStatesAdapter(ArrayList<String> statesList) {
        this.statesList = statesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyclerview_item_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(statesList.get(position));
    }

    @Override
    public int getItemCount() {
        return statesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mTextView = v.findViewById(R.id.state_name);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Position: " + this.getAdapterPosition());
        }
    }
}