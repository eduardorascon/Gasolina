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
    private LinearLayoutManager llm;
    private RecyclerViewStatesAdapter adapter;

    protected void onStart() {
        super.onStart();
        presenter.loadStates();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this, null);
        rv = findViewById(R.id.states_recycler_view);
        rv.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        //divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), llm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void displayStates(List<StateInfo> stateList) {
        adapter = new RecyclerViewStatesAdapter((ArrayList<StateInfo>) stateList);
        rv.setAdapter(adapter);
    }

}