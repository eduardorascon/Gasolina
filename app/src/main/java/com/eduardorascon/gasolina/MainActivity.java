package com.eduardorascon.gasolina;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
import com.eduardorascon.gasolina.sqlite.DatabaseHandler;
import com.eduardorascon.gasolina.sqlite.Municipio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<Municipio> municipioList = new ArrayList<>();
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
        adapter = new PrecioGasolinaAdapter(municipioList);
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
        municipioList.clear();

        DatabaseHandler db = DatabaseHandler.getInstance(this);
        municipioList = db.getAllMunicipios();

        adapter.notifyDataSetChanged();

        if (municipioList.size() == 0) {
            emptyTextView.setVisibility(View.VISIBLE);
            emptyTextView.setText("BUSQUEDA SIN RESULTADOS. INTENTAR BUSCAR NUEVAMENTE.");
            emptyTextView.setTextColor(ContextCompat.getColor(this, R.color.red));
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