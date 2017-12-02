package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "ciudades",
        indices = @Index("state_id"),
        foreignKeys = @ForeignKey(entity = State.class, parentColumns = "state_id", childColumns = "state_id"))
public class City {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "city_id")
    private int mId;

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

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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