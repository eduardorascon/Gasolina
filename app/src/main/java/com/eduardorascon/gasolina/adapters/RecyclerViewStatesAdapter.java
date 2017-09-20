package com.eduardorascon.gasolina.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.CitiesActivity;
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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";
        private static final long CLICK_TIME_INTERVAL = 300;
        private long mLastClickTime = System.currentTimeMillis();

        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mTextView = v.findViewById(R.id.state_name);
        }

        //Maybe this can be repleaced with this answer: https://stackoverflow.com/a/33031936
        @Override
        public void onClick(View view) {

            if (isClickValid() == false)
                return;

            Log.d(TAG, "Position: " + this.getAdapterPosition());
            Intent intent = new Intent(view.getContext(), CitiesActivity.class);
            intent.putExtra("ESTADO", mTextView.getText());
            view.getContext().startActivity(intent);
        }

        private boolean isClickValid() {
            long now = System.currentTimeMillis();
            if (now - mLastClickTime < CLICK_TIME_INTERVAL)
                return false;

            mLastClickTime = now;
            return true;
        }
    }
}
