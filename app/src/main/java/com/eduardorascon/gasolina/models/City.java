package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "ciudades",
        indices = @Index("state_id"),
        foreignKeys = @ForeignKey(entity = State.class, parentColumns = "stateId", childColumns = "state_id"))
public class City {
    @PrimaryKey(autoGenerate = true)
    public int cityId;

    @ColumnInfo(name = "nombre_ciudad")
    public String name;

    @ColumnInfo(name = "ultima_actualizacion")
    public Date lastUpdate;

    @ColumnInfo(name = "state_id")
    public int stateId;
}