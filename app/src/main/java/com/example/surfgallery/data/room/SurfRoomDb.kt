package com.example.surfgallery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.surfgallery.data.models.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class SurfRoomDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: SurfRoomDb? = null

        fun getDb(context: Context): SurfRoomDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SurfRoomDb::class.java,
                    "surf_db"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}