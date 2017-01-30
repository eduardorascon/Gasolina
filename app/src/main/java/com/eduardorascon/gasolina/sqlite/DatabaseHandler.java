package com.eduardorascon.gasolina.sqlite;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.eduardorascon.gasolina.CSVReader;
import com.eduardorascon.gasolina.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static DatabaseHandler sInstance;
    private final static String DATABASE_NAME = "db1.db";
    private Context mContext;

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    public static synchronized DatabaseHandler getInstance(Context context){
        if (sInstance == null){
            sInstance = new DatabaseHandler(context.getApplicationContext());
        }

        return sInstance;
    }

    public void setup(SQLiteDatabase db) {

        CSVReader reader = new CSVReader(mContext);
        List<String[]> lines = reader.readAll();
        int indice = 0;
        for (String[] s : lines) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", indice++);
            contentValues.put("estado", s[2]);
            contentValues.put("municipio", s[3]);
            contentValues.put("verde", s[4]);
            contentValues.put("roja", s[5]);
            contentValues.put("diesel", s[6]);
            Log.i("INSERT", "" + indice);
            db.insert("municipios", null, contentValues);
        }

        db.close();
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
                municipiosList.add(mpio);
            } while (cursor.moveToNext());
        }

        return municipiosList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (mContext.getApplicationContext().getDatabasePath(DATABASE_NAME).exists() == true) {
            return;
        }

        String CREATE_MUNICIPIOS_TABLE = "create table municipios(_id integer primary key, estado text, municipio text, verde text, roja text, diesel text)";
        db.execSQL(CREATE_MUNICIPIOS_TABLE);
        Log.i("CREATE", "BD CREADA");

        setup(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists municipios");
        onCreate(db);
    }
}