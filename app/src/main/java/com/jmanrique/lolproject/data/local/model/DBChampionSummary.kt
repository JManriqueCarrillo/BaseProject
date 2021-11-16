package com.jmanrique.lolproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jmanrique.lolproject.domain.entities.ChampionSummary

@Entity(tableName = "championSummary")
data class DBChampionSummary(
    @PrimaryKey
    val id: Int,
    val alias: String,
    val name: String,
    val roles: List<String>,
    val squarePortraitPath: String
){
    fun toChampionSummary() = ChampionSummary(
        id = id,
        alias = alias,
        name = name,
        roles = roles,
        squarePortraitPath = squarePortraitPath
    )
}