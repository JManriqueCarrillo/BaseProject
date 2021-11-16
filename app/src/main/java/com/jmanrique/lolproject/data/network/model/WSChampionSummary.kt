package com.jmanrique.lolproject.data.network.model

import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.google.gson.annotations.SerializedName

class WSChampionSummary(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("squarePortraitPath")
    val squarePortraitPath: String
) {
    fun toChampionSummary() = ChampionSummary(
        alias = alias,
        id = id,
        name = name,
        roles = roles,
        squarePortraitPath = squarePortraitPath
    )
}