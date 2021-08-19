package com.onboarding.pronosticAR.mvp.model

import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.data.service.Service

class MainModel(private val service: Service) : MainContract.MainModel {

    override fun getWeatherInfo() = service.getWeather()
}
