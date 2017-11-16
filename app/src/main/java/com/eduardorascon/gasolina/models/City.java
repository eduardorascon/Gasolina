package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ciudades")
public class City {
	@PrimaryKey(autoGenerate = true)
	public int cityId;

	@ColumnInfo(name = "nombre_ciudad")
	public String name;

	public int stateId;
}