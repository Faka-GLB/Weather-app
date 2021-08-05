package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class ApiResponse(
    @SerializedName("cod")
    val cod: String = ConstantUtils.DEFAULT_STRING_VALUE,

    @SerializedName("message")
    val message: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("cnt")
    val cnt: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("list")
    val list: List<ListResponse> = emptyList(),

    @SerializedName("city")
    val city: CityResponse = CityResponse()
)
