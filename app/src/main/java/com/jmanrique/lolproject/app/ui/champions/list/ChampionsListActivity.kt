package com.jmanrique.lolproject.app.ui.champions.list

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmanrique.lolproject.app.ui.base.BaseActivity
import com.jmanrique.lolproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChampionsListActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: ChampionsListViewModel by viewModels()

    @Inject
    lateinit var championsListAdapter: ChampionsListAdapter

    override fun bindViewToModel() {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getChampionSummary()

        viewModel.championSummaryList.observe(this, {
            championsListAdapter.data = it
            binding.championsList.layoutManager = LinearLayoutManager(this)
            binding.championsList.adapter = championsListAdapter
        })

        viewModel.showLoading.observe(this, {
            viewModel.showLoading.value = it
        })
    }

    override fun inflate(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

}