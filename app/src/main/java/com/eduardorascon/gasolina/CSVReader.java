package com.eduardorascon.gasolina;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    InputStream inputStream;

    public CSVReader(Context context) {
        this.inputStream = context.getResources().openRawResource(R.raw.testdata);
    }

    public List<String[]> readAll() {
        List<String[]> resultList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String csvLine;
        try {
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] row = csvLine.split(",");
                resultList.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo. " + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Error al cerrar lector." + e);
            }
        }

        return resultList;
    }
}