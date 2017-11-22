package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "estados")
public class State {
    @PrimaryKey(autoGenerate = true)
    private int stateId;

    @ColumnInfo(name = "nombre_entidad")
    private String mName;

    @ColumnInfo(name = "ultima_actualizacion")
    private Date mLastUpdate;

    public State(String name, Date lastUpdate) {
        this.mName = name;
        this.mLastUpdate = lastUpdate;
    }

    public int getStateId() {
        return stateId;
    }

    public String getName() {
        return mName;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }
}
