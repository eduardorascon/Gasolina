package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CityDao {
    @Query("SELECT * FROM ciudades WHERE state_id = :stateId")
    public List<City> getAllCitiesFromState(int stateId);

    @Query("SELECT COUNT(*) FROM ciudades")
    public int countCities();

    @Insert
    public void insertCity(City city);

    @Insert
    public void insertCities(List<City> cities);

    @Update
    public void updateCity(City city);

    @Delete
    public void deleteCity(City city);
}