package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eduardorascon.gasolina.adapters.RecyclerViewCitiesAdapter;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity implements CitiesActivityView {

    private CitiesActivityPresenter presenter;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private RecyclerViewCitiesAdapter adapter;
    private String stateName;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadCities(stateName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        presenter = new CitiesActivityPresenter(this);
        rv = findViewById(R.id.cities_recycler_view);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        //divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbar_layout);

        Bundle bundle = getIntent().getExtras();
        stateName = bundle.getString("ESTADO");

        toolbarLayout.setTitle(stateName);
    }

    @Override
    public void displayCities(List<CityInfo> cityList) {
        adapter = new RecyclerViewCitiesAdapter((ArrayList<CityInfo>) cityList);
        rv.setAdapter(adapter);
    }
}
