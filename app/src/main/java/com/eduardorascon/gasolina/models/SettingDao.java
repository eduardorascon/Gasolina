package com.eduardorascon.gasolina.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface SettingDao {
    @Query("SELECT COUNT(*) FROM configuracion_firebase")
    public int countSettings();

    @Query("SELECT * FROM configuracion_firebase ORDER BY setting_id desc LIMIT 1")
    public Setting getSettings();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSettings(Setting setting);
}
