package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class SysResponse(
    @SerializedName("pod")
    val pod: String = ConstantUtils.DEFAULT_STRING_VALUE
)
