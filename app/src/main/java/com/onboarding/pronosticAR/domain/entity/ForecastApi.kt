package com.onboarding.pronosticAR.domain.entity

data class ForecastApi(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherList>,
    val city: City
)
