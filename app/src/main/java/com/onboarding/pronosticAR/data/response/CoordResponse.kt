package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class CoordResponse (
    @SerializedName("lat")
    val latitude: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("lon")
    val longitude: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE
)
