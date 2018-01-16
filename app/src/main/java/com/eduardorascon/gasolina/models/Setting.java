package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "configuracion_firebase")
public class Setting {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "setting_id")
    private int mId;

    @ColumnInfo(name = "fecha_actualizacion")
    private Date mLastUpdate;

    @ColumnInfo(name = "fecha_expiracion")
    private Date mExpirationDate;

    public Setting(Date lastUpdate, Date expirationDate) {
        this.mLastUpdate = lastUpdate;
        this.mExpirationDate = expirationDate;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }

    public Date getExpirationDate() {
        return mExpirationDate;
    }
}
