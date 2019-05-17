package com.example.labo07.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.labo07.Database.GitHubDAO
import com.example.labo07.Database.GitHubRepo

class GitHubRepoRepository(private val repoDao: GitHubDAO) {

    @WorkerThread
    suspend fun insert(repo: GitHubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GitHubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()


}