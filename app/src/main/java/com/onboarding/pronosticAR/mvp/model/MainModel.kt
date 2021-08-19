package com.onboarding.pronosticAR.mvp.model

import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.data.service.WeatherServiceI

class MainModel(private val service: WeatherServiceI) : MainContract.MainModel {

    override fun getWeatherInfo() = service.getWeather()
}
