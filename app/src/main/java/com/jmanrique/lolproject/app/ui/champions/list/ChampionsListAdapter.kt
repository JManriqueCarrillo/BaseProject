package com.jmanrique.lolproject.app.ui.champions.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jmanrique.lolproject.R
import com.jmanrique.lolproject.databinding.ChampionListItemBinding
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.utils.extensions.getAvatarUrl
import javax.inject.Inject

class ChampionsListAdapter @Inject constructor(val context: Context) :
    RecyclerView.Adapter<ChampionsListAdapter.ViewHolder>() {

    var data: List<ChampionSummary> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ChampionListItemBinding.inflate(LayoutInflater.from(context), parent, false)
    )

    override fun onBindViewHolder(holder: ChampionsListAdapter.ViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: ChampionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(champion: ChampionSummary) {
            binding.apply {
                champion.also {
                    Glide.with(context)
                        .load(getAvatarUrl(it.id.toString()))
                        .placeholder(R.drawable.champion_avatar_placeholder)
//                        .error()
                        .into(binding.championListAvatar)

                    binding.championListName.text = it.name
                }
            }
        }
    }


}