package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class CloudResponse(
    @SerializedName("all")
    val all: Int = ConstantUtils.DEFAULT_INT_VALUE
)
