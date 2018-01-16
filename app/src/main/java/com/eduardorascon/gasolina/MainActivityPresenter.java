package com.eduardorascon.gasolina;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter {

    private MainActivityView view;
    private List<StateInfo> stateList = new ArrayList();

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
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
                    stateList.add(new StateInfo(value));
                }

                view.displayStates(stateList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}