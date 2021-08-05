package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class CityResponse (
    @SerializedName("id")
    val id: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("name")
    val name: String = ConstantUtils.DEFAULT_STRING_VALUE,

    @SerializedName("coord")
    val coordinates: CoordResponse = CoordResponse(),

    @SerializedName("country")
    val country : String = ConstantUtils.DEFAULT_STRING_VALUE,

    @SerializedName("population")
    val population: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("timezone")
    val timezone: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("sunrise")
    val sunrise: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("sunset")
    val sunset: Int = ConstantUtils.DEFAULT_INT_VALUE
)
