package com.swanky.superherobook.model

data class SuperHero(
    val name: String,
    val image: Int,
    val description: String,
    val powerLevel: Int,
    val team: String,
    val abilities: List<String>,
    val originCity: String,
    val publisher: String,
    val firstAppearanceYear: Int
)