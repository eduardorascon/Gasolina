package com.eduardorascon.gasolina.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.CitiesActivity;
import com.eduardorascon.gasolina.CityInfo;
import com.eduardorascon.gasolina.R;

import java.util.ArrayList;

public class RecyclerViewCitiesAdapter extends RecyclerView.Adapter<RecyclerViewCitiesAdapter.ViewHolder> {
    private ArrayList<CityInfo> cityList;

    public RecyclerViewCitiesAdapter(ArrayList<CityInfo> cityList) {
        this.cityList = cityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyclerview_item_row, parent, false);
        RecyclerViewCitiesAdapter.ViewHolder vh = new RecyclerViewCitiesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(cityList.get(position).getCityName());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
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

        @Override
        public void onClick(View view) {

            boolean validClick = isClickValid();
            if (validClick == false)
                return;

            Log.d(TAG, "Position: " + this.getAdapterPosition());
            //Intent intent = new Intent(view.getContext(), CitiesActivity.class);
            //intent.putExtra("CIUDAD", mTextView.getText());
            //view.getContext().startActivity(intent);
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