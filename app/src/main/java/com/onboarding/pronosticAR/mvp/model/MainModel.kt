package com.onboarding.pronosticAR.mvp.model

import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.data.WeatherService

class MainModel(private val service: WeatherService) : MainContract.MainModel {

    override fun getWeatherInfo() = service.getWeather()
}
