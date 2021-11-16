package com.jmanrique.lolproject.domain.entities

data class ChampionSummary(
    val id: Int,
    val alias: String,
    val name: String,
    val roles: List<String>,
    val squarePortraitPath: String
)