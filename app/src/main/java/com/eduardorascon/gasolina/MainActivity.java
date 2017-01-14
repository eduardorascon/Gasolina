package com.eduardorascon.gasolina;

import android.content.Context;
import android.content.res.AssetManager;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.eduardorascon.gasolina.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readCSVFile(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.testdata);
        CSVReader csv = new CSVReader(inputStream);
        List<String[]> items = csv.read();

        TextView x = (TextView) findViewById(R.id.textView);
        x.setText("" + items.size());
    }
}