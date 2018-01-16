package com.eduardorascon.gasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PricesActivity extends AppCompatActivity {

    private String prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);

        Bundle bundle = getIntent().getExtras();
        prices = bundle.getString("PRECIOS");
    }
}
