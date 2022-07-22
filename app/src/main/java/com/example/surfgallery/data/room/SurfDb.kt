package com.example.surfgallery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.surfgallery.data.models.User
import com.example.surfgallery.data.room.dao.UserDao

@Database(
    version = 1,
    entities = [User::class]
)
abstract class SurfDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: SurfDb? = null

        fun getDb(context: Context): SurfDb {
            val dbInstance = INSTANCE
            if (dbInstance != null) {
                return dbInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SurfDb::class.java,
                    "surfDb"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}