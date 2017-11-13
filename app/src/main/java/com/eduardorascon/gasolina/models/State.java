package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "estados")
public class State {
    @PrimaryKey
    public int StateId;
    @ColumnInfo(name = "entidad")
    public String Name;
}
