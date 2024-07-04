package com.example.building3.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Создайте файл BuildDatabase.kt
@Database(entities = [BuildEntity::class], version = 1)
abstract class BuildDatabase : RoomDatabase() {
    abstract fun buildDao(): BuildDao

    companion object {
        @Volatile
        private var INSTANCE: BuildDatabase? = null

        fun getInstance(context: Context): BuildDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BuildDatabase::class.java,
                    "build_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
