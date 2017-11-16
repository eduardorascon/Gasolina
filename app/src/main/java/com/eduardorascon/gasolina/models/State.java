package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "estados")
public class State {
    @PrimaryKey(autoGenerate = true)
    public int stateId;

    @ColumnInfo(name = "nombre_entidad")
    public String name;

    @ColumnInfo(name = "ultima_actualizacion")
    public Date lastUpdate;
}
