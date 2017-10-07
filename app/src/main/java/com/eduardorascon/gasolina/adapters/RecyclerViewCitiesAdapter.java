package com.eduardorascon.gasolina.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardorascon.gasolina.CityInfo;
import com.eduardorascon.gasolina.PricesActivity;
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
        View v = inflater.inflate(R.layout.cities_recyclerview_item_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CityInfo cityInfo = cityList.get(position);
        holder.cityInfo = cityInfo;
        holder.cityName.setText(cityInfo.getCityName());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";
        private static final long CLICK_TIME_INTERVAL = 300;
        private long mLastClickTime = System.currentTimeMillis();
        private TextView cityName;
        private CityInfo cityInfo;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            cityName = v.findViewById(R.id.city_name);
        }

        //Maybe this can be repleaced with this answer: https://stackoverflow.com/a/33031936
        @Override
        public void onClick(View view) {

            boolean validClick = isClickValid();
            if (validClick == false)
                return;

            Log.d(TAG, "Position: " + this.getAdapterPosition());
            Intent intent = new Intent(view.getContext(), PricesActivity.class);

            //Maybe change this to a parcelable.
            intent.putExtra("CIUDAD", cityName.getText());
            intent.putExtra("MAGNA", cityInfo.getMagna());
            intent.putExtra("PREMIUM", cityInfo.getPremium());
            intent.putExtra("DIESEL", cityInfo.getDiesel());

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
