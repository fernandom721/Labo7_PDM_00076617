package com.example.labo07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo07.Database.GitHubRepo
import com.example.labo07.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        bt_name.setOnClickListener {
            val name = et_view.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GitHubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos ->
            Log.d("LISTA DE REPOS", "-------------------------------------------------")
            for (repo in repos){
                Log.d("LISTA DE REPOS", repo.name)
            }

        })

    }
}
