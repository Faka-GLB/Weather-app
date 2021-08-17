package com.onboarding.pronosticAR.contract

import com.onboarding.pronosticAR.domain.entity.WeatherListItem

interface DetailedWeatherContract {
    interface DetailedWeatherPresenter {
        fun onReturnButtonPressed()
        fun initInformation(weatherItem: WeatherListItem)
    }

    interface DetailedWeatherView {
        fun showDetailedWeatherInfo(weatherItem: WeatherListItem)
        fun dismissFragment()
    }
}
