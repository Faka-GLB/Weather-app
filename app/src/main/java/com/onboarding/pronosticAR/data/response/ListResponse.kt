package com.onboarding.pronosticAR.data.response

import com.google.gson.annotations.SerializedName
import com.onboarding.pronosticAR.utils.ConstantUtils

data class ListResponse(
    @SerializedName("dt")
    val date: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("main")
    val mainResponse: TemperatureResponse = TemperatureResponse(),

    @SerializedName("weather")
    val weatherResponse: List<WeatherResponse> = emptyList(),

    @SerializedName("clouds")
    val clouds: CloudResponse = CloudResponse(),

    @SerializedName("wind")
    val wind: WindResponse = WindResponse(),

    @SerializedName("visibility")
    val visibility: Int = ConstantUtils.DEFAULT_INT_VALUE,

    @SerializedName("pop")
    val pop: Double = ConstantUtils.DEFAULT_DOUBLE_VALUE,

    @SerializedName("rain")
    val rain: RainResponse = RainResponse(),

    @SerializedName("sys")
    val sys: SysResponse = SysResponse(),

    @SerializedName("dt_txt")
    val dtTxt: String = ConstantUtils.DEFAULT_STRING_VALUE
)
