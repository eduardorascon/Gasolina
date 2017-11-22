package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "configuracion_firebase")
public class Setting {
    @PrimaryKey(autoGenerate = true)
    private int settingId;

    @ColumnInfo(name = "fecha_actualizacion")
    private Date mLastUpdate;

    @ColumnInfo(name = "fecha_expiracion")
    private Date mExpirationDate;

    public Setting(Date lastUpdate, Date expirationDate) {
        this.mLastUpdate = lastUpdate;
        this.mExpirationDate = expirationDate;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }

    public Date getExpirationDate() {
        return mExpirationDate;
    }
}
