package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter presenter;
    private ListView listView;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadStates();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this, null);
        listView = findViewById(R.id.listView);
    }

    @Override
    public void displayStates(List<String> stateList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);
        adapter.addAll(stateList);
        listView.setAdapter(adapter);
    }
}