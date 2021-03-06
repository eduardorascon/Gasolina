package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eduardorascon.gasolina.adapters.RecyclerViewStatesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter presenter;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private RecyclerViewStatesAdapter adapter;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadStates();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        rv = findViewById(R.id.states_recyclerview);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        //RecyclerView divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void displayStates(List<StateInfo> stateList) {
        adapter = new RecyclerViewStatesAdapter((ArrayList<StateInfo>) stateList);
        rv.setAdapter(adapter);
    }
}