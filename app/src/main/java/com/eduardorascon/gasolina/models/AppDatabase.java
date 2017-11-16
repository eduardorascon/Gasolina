package com.eduardorascon.gasolina.models;

@Database(entities = {State.class, City.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
	public abtract StateDao stateDao();

	public abstract CityDao cityDao();
}