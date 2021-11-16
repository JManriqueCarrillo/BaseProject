package com.jmanrique.lolproject.app.ui.main

import android.view.LayoutInflater
import com.jmanrique.lolproject.databinding.ActivityMainBinding
import com.jmanrique.lolproject.app.ui.base.BaseActivity
import androidx.activity.viewModels

class MainActivity: BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun inflate(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)
}