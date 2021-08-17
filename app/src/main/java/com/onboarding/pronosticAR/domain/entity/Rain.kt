package com.onboarding.pronosticAR.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rain (
    val h: Double
) : Parcelable
