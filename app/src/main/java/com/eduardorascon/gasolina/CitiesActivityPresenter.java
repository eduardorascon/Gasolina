package com.eduardorascon.gasolina;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivityPresenter {

    private CitiesActivity view;
    private List<CityInfo> cityList = new ArrayList<>();

    public CitiesActivityPresenter(CitiesActivity view) {
        this.view = view;
    }

    public void loadCities(String stateName) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("precios/" + stateName);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cityList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String cityName = postSnapshot.getKey();
                    String cityPrices = postSnapshot.getValue().toString();
                    cityList.add(new CityInfo(cityName, cityPrices));
                }

                view.displayCities(cityList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}