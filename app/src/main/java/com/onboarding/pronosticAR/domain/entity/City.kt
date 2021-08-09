package com.onboarding.pronosticAR.domain.entity

data class City (
    val id: Int,
    val name: String,
    val coord: Coordinates,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)
