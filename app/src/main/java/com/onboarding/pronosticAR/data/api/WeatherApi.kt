package com.onboarding.pronosticAR.data.api

import com.onboarding.pronosticAR.data.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?")
    fun callWeatherInfo(@Query("q") city: String, @Query("appid") apiId: String, @Query("units") units: String): Call<ApiResponse>
}
