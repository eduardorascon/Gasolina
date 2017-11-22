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
    private int cityId;

    @ColumnInfo(name = "nombre_ciudad")
    private String mName;

    @ColumnInfo(name = "ultima_actualizacion")
    private Date mLastUpdate;

    @ColumnInfo(name = "state_id")
    private int mStateId;

    public City(String name, Date lastUpdate, int stateId) {
        this.mName = name;
        this.mLastUpdate = lastUpdate;
        this.mStateId = stateId;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return mName;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }

    public int getStateId() {
        return mStateId;
    }
}