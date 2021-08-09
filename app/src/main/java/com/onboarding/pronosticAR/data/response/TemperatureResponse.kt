package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class TemperatureResponse(
    @SerializedName("temp")
    val temperature: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("feels_like")
    val feelsLike: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("temp_min")
    val minimum: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("temp_max")
    val maximum: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("pressure")
    val pressure: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("sea_level")
    val seaLevel: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("ground_level")
    val groundLevel: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("humidity")
    val humidity: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("temp_kf")
    val tempKf: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE
)
