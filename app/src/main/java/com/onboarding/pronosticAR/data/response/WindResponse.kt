package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class WindResponse(
    @SerializedName("speed")
    val speed: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("deg")
    val deg: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("gust")
    val gust: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE
)
