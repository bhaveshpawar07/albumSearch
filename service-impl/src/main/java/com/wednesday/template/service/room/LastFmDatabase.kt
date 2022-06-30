package com.wednesday.template.service.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wednesday.template.service.lastFm.LastFmLocalServiceImpl
import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails

@Database(
    entities = [LocalAlbumDetails::class],
    version = 1
)

abstract class LastFmDatabase : RoomDatabase() {
    abstract fun databaseDao(): LastFmLocalServiceImpl
}
