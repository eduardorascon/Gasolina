package com.eduardorascon.gasolina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    InputStream inputStream = null;

    public CSVReader(InputStream is) {
        this.inputStream = is;
    }

    public List<String[]> search(String searchigFor) {
        List<String[]> resultList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String csvLine;
        try {
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] row = csvLine.split(",");

                if (row[3].toLowerCase().contains(searchigFor.toLowerCase()))
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