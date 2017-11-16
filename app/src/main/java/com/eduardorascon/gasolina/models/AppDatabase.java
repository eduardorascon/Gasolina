package com.eduardorascon.gasolina.models;

@Database(entities = {State.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
	public abtract StateDao stateDao();
}