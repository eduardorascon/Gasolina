package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "configuracion")
public class Settings {
    @PrimaryKey(autoGenerate = true)
    public int settingId;

    @ColumnInfo(name = "fecha_actualizacion")
    public String lastUpdate;

    @ColumnInfo(name = "fecha_expiracion")
    public String expirationDate;
}
