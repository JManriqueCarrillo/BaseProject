package com.jmanrique.lolproject.domain.entities

data class ChampionSummary(
    val alias: String,
    val id: Int,
    val name: String,
    val roles: List<String>,
    val squarePortraitPath: String
)