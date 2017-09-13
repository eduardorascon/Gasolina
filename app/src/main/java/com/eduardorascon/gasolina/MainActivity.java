package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter presenter;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private StatesAdapter adapter;

    protected void onStart() {
        super.onStart();
        presenter.loadStates();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this, null);
        rv = (RecyclerView) findViewById(R.id.states_recycler_view);
        rv.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

    @Override
    public void displayStates(List<String> stateList) {
        adapter = new StatesAdapter((ArrayList<String>) stateList);
        rv.setAdapter(adapter);
    }

    public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.ViewHolder> {
        private ArrayList<String> statesList;

        public StatesAdapter(ArrayList<String> statesList) {
            this.statesList = statesList;
        }

        @Override
        public StatesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_row, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(StatesAdapter.ViewHolder holder, int position) {
            holder.mTextView.setText(statesList.get(position));
        }

        @Override
        public int getItemCount() {
            return statesList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }
    }
}