package com.eduardorascon.gasolina.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eduardorascon.gasolina.CSVReader;
import com.eduardorascon.gasolina.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static DatabaseHandler dbInstance;
    private final static String DATABASE_NAME = "db1.db";
    private Context context;

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    public static synchronized DatabaseHandler getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = new DatabaseHandler(context);
        }

        return dbInstance;
    }

    public void setup(SQLiteDatabase db) {
        CSVReader reader = new CSVReader(context);
        List<String[]> lines = reader.readAll();

        int indice = 0;
        for (String[] s : lines) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", indice++);
            contentValues.put("estado", s[2]);
            contentValues.put("municipio", s[3]);
            contentValues.put("verde", s[4]);
            contentValues.put("roja", s[5]);
            contentValues.put("diesel", s[6]);
            contentValues.put("es_favorito", 0);
            db.insert("municipios", null, contentValues);
        }
    }

    public void setMunicipioFavorite(long id, boolean checked) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] params = {checked ? "1" : "0", String.valueOf(id)};
        db.rawQuery(context.getString(R.string.db_update_municipios_set_es_favorito), params);
    }

    public List<Municipio> getMunicipios(String stringToSearch) {
        List<Municipio> municipiosList = new ArrayList<>();
        String selectQuery = context.getString(R.string.db_search_municipios_by_estado_or_municipio);

        SQLiteDatabase db = this.getReadableDatabase();
        String[] params = {"%" + stringToSearch.trim() + "%", "%" + stringToSearch.trim() + "%"};
        Cursor cursor = db.rawQuery(selectQuery, params);

        if (cursor.moveToFirst()) {
            do {
                Municipio mpio = new Municipio();
                mpio.setId(cursor.getInt(0));
                mpio.setEstado(cursor.getString(1));
                mpio.setMunicipio(cursor.getString(2));
                mpio.setVerde(cursor.getString(3));
                mpio.setRoja(cursor.getString(4));
                mpio.setDiesel(cursor.getString(5));
                mpio.setIsFavorito(cursor.getInt(6));
                municipiosList.add(mpio);
            } while (cursor.moveToNext());
        }

        return municipiosList;
    }

    public List<Municipio> getAllMunicipios() {
        List<Municipio> municipiosList = new ArrayList<>();
        String selectQuery = "SELECT * FROM municipios";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Municipio mpio = new Municipio();
                mpio.setId(cursor.getInt(0));
                mpio.setEstado(cursor.getString(1));
                mpio.setMunicipio(cursor.getString(2));
                mpio.setVerde(cursor.getString(3));
                mpio.setRoja(cursor.getString(4));
                mpio.setDiesel(cursor.getString(5));
                mpio.setIsFavorito(cursor.getInt(6));
                municipiosList.add(mpio);
            } while (cursor.moveToNext());
        }

        return municipiosList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(context.getString(R.string.db_create_table_municipios));
        setup(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(this.context.getString(R.string.db_drop_table_municipios));
        onCreate(db);
    }
}