package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class WeatherResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("main")
    val weather: String = ConstantUtils.DEFAULT_STRING_VALUE,

    @SerializedName("description")
    val description: String = ConstantUtils.DEFAULT_STRING_VALUE,

    @SerializedName("icon")
    val icon: String = ConstantUtils.DEFAULT_STRING_VALUE
)
