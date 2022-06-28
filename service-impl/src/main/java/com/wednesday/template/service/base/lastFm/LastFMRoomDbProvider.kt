package com.wednesday.template.service.base.lastFm

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.wednesday.template.service.room.LastFmDatabase

fun getLastFmRoomDatabase(applicationContext: Context) : LastFmDatabase{
    return databaseBuilder(
        applicationContext,
        LastFmDatabase::class.java,
        "android_lastFm_database"
    ).build()
}