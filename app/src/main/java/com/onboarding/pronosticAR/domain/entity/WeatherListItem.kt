package com.onboarding.pronosticAR.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherListItem(
    val dt: Int,
    val temperatureResponse: MainTemperature,
    val descriptionResponse: List<WeatherDescription>,
    val clouds: Cloud,
    val wind: Wind,
    val visibility: Int,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val dtTxt: String
) : Parcelable
