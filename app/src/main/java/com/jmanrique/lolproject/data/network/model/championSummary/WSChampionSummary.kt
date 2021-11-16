package com.jmanrique.lolproject.data.network.model.championSummary

import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.google.gson.annotations.SerializedName

class WSChampionSummary(
    @SerializedName("id")
    val id: Int,
    @SerializedName("alias")
    val alias: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("squarePortraitPath")
    val squarePortraitPath: String
) {
    fun toChampionSummary() = ChampionSummary(
        id = id,
        alias = alias,
        name = name,
        roles = roles,
        squarePortraitPath = squarePortraitPath
    )
}