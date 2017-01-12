package com.eduardorascon.gasolina.gasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readCSVFile(View view) {
        List<String> csv_items = new ArrayList<String>();
        csv_items.add(0,"Fuuu");
        csv_items.add(1,"XYZ");

        TextView x = (TextView) findViewById(R.id.textView);
        x.setText("" + csv_items.size());
    }
}
