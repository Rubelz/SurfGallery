package com.example.surfgallery

import android.app.Application
import com.example.surfgallery.data.room.SurfRoomDb

class SurfApplication: Application() {

    val database: SurfRoomDb by lazy { SurfRoomDb.getDb(this) }

}