package com.example.labo07.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){
    abstract fun repoDao(): GitHubDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstace(Appcontext: Context): RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(Appcontext, RoomDB::class.java,"RepoDB")
                    .build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}
