package com.example.building3.Databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BuildDao {
    @Insert
    suspend fun insertBuild(build: BuildEntity)

    @Query("SELECT * FROM builds")
    suspend fun getAllBuilds(): List<BuildEntity>
}