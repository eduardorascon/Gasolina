package com.eduardorascon.gasolina;

import android.content.Context;
import android.content.res.AssetManager;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;
import com.eduardorascon.gasolina.adapters.PrecioGasolinaAdapter;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<PrecioGasolina> precioGasolinas = new ArrayList<>();
    private RecyclerView recyclerView;
    private PrecioGasolinaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        adapter = new PrecioGasolinaAdapter(precioGasolinas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void readCSVFile(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.testdata);
        CSVReader csv = new CSVReader(inputStream);
        List<String[]> items = csv.read();

        TextView x = (TextView) findViewById(R.id.textView);
        x.setText("" + items.size());

        for (String[] s : items) {
            precioGasolinas.add(new PrecioGasolina(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}