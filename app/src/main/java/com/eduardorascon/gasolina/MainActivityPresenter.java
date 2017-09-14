package com.eduardorascon.gasolina;

import com.eduardorascon.gasolina.repositories.StatesRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter {
    private MainActivityView view;
    private StatesRepository statesRepository;
    private List<String> stateList = new ArrayList();

    public MainActivityPresenter(MainActivityView view, StatesRepository statesRepository) {
        this.view = view;
        this.statesRepository = statesRepository;
    }

    public void loadStates() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("estados");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                stateList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String value = postSnapshot.getKey();
                    stateList.add(value);
                }

                view.displayStates(stateList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}