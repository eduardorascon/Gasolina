package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.Query;

public interface SettingDao {
    @Query("SELECT COUNT(*) FROM configuracion_firebase")
    public int countSettings();
}
