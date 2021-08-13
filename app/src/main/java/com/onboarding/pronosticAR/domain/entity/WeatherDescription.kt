package com.onboarding.pronosticAR.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherDescription(
    val id: Int,
    val weather: String,
    val description: String,
    val icon: String
) : Parcelable
