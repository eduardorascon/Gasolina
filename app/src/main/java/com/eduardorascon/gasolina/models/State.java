package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "estados")
public class State {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "state_id")
    private int mId;

    @ColumnInfo(name = "nombre_entidad")
    private String mName;

    @ColumnInfo(name = "ultima_actualizacion")
    private Date mLastUpdate;

    public State(String name, Date lastUpdate) {
        this.mName = name;
        this.mLastUpdate = lastUpdate;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }
}
