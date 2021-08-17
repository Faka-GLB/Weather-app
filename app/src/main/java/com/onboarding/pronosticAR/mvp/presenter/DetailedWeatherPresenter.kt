package com.onboarding.pronosticAR.mvp.presenter

import com.onboarding.pronosticAR.contract.DetailedWeatherContract
import com.onboarding.pronosticAR.domain.entity.WeatherListItem

class DetailedWeatherPresenter(private val view: DetailedWeatherContract.DetailedWeatherView): DetailedWeatherContract.DetailedWeatherPresenter {

    override fun onReturnButtonPressed() {
        view.dismissFragment()
    }

    override fun initInformation(weatherItem: WeatherListItem) {
        view.showDetailedWeatherInfo(weatherItem)
    }
}
