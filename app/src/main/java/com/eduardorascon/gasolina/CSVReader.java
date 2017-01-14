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

    public List<String[]> read(){
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String csvLine;
        try {
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] row = csvLine.split(",");
                resultList.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo. " + e);
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Error al cerrar lector." +e);
            }
        }

        return resultList;
    }
}
