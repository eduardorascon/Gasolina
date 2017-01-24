package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eduardorascon.gasolina.adapters.PrecioGasolinaAdapter;
import com.eduardorascon.gasolina.pojos.PrecioGasolina;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<PrecioGasolina> precioGasolinas = new ArrayList<>();
    private RecyclerView recyclerView;
    private PrecioGasolinaAdapter adapter;
    private TextView emptyTextView;
    private ImageView backgroundIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyTextView = (TextView) findViewById(R.id.empty_text_view);
        backgroundIconImageView = (ImageView) findViewById(R.id.background_icon_image_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new PrecioGasolinaAdapter(precioGasolinas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if(query == null || query.trim().isEmpty()){
            emptyTextView.setVisibility(View.VISIBLE);
            emptyTextView.setText("LA BUSQUEDA ES INCORRECTA. INTENTAR BUSCAR NUEVAMENTE.");
            backgroundIconImageView.setVisibility(View.VISIBLE);

            return false;
        }

        InputStream inputStream = getResources().openRawResource(R.raw.testdata);
        CSVReader reader = new CSVReader(inputStream);
        List<String[]> lines = reader.search(query);

        precioGasolinas.clear();
        for (String[] s : lines) {
            precioGasolinas.add(new PrecioGasolina(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
        }

        adapter.notifyDataSetChanged();

        if (precioGasolinas.size() == 0) {
            emptyTextView.setVisibility(View.VISIBLE);
            emptyTextView.setText("BUSQUEDA SIN RESULTADOS. INTENTAR BUSCAR NUEVAMENTE.");
            backgroundIconImageView.setVisibility(View.VISIBLE);
        } else {
            emptyTextView.setVisibility(View.GONE);
            backgroundIconImageView.setVisibility(View.GONE);
        }

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}