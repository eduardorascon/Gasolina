package com.eduardorascon.gasolina;

import com.eduardorascon.gasolina.repositories.CitiesRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivityPresenter {

    private CitiesActivity view;
    private CitiesRepository repository;
    private List<CityInfo> cityList = new ArrayList<>();

    public CitiesActivityPresenter(CitiesActivity view, CitiesRepository citiesRepository) {
        this.view = view;
        this.repository = citiesRepository;
    }

    public void loadCities(String stateName) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("precios/" + stateName);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cityList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String value = postSnapshot.getKey();
                    cityList.add(new CityInfo(value));
                }

                view.displayCities(cityList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}