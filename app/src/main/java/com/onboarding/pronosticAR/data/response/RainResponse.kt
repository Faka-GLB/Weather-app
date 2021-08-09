package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class RainResponse (
    @SerializedName("3h")
    val h: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE
)
