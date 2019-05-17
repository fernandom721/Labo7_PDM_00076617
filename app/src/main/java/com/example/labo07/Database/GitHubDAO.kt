package com.example.labo07.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GitHubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GitHubRepo)

    @Query("SELECT * FROM repos")
    fun getAllRepos(): LiveData<List<GitHubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()

}