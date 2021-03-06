package com.onboarding.pronosticAR.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainTemperature(
    val temperature: Double,
    val feelsLike: Double,
    val min: Double,
    val max: Double,
    val pressure: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val humidity: Int,
    val tempKf: Double
) : Parcelable
