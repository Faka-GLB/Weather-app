package com.onboarding.pronosticAR.domain.entity

data class ForecastApiEntity(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val listItem: List<WeatherListItem>,
    val city: City
)
