package com.example.popularrepo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.popularrepo.BaseApplication
import com.example.popularrepo.R
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as BaseApplication).getAppComponent().inject(this)
        var viewModel = ViewModelProviders.of(this,viewModelFactory).get(RepoViewModel::class.java)
        viewModel.getRepoMutableLiveData().observe(this, Observer {
            Log.d(TAG, "onCreate: " + it.name)
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}