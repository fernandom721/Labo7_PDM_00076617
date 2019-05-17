package com.example.labo07.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo07.Database.GitHubRepo
import com.example.labo07.Database.RoomDB
import com.example.labo07.Repository.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class  GitHubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository : GitHubRepoRepository

    init{
        val repoDao = RoomDB.getInstace(app).repoDao()
        repository = GitHubRepoRepository(repoDao)
    }

    fun insert(repo: GitHubRepo)= viewModelScope.launch (Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GitHubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()

}

