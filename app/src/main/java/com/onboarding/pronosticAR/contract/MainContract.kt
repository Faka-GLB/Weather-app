package com.onboarding.pronosticAR.contract

import android.os.Bundle
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import io.reactivex.rxjava3.core.Observable

interface MainContract {

    interface MainPresenter {
        fun getWeatherInfo()
        fun onWeatherItemPressed(weatherItem: WeatherListItem)
    }

    interface MainModel {
        fun getWeatherInfo(): Observable<ForecastApiEntity>
    }

    interface MainView {
        fun showWeather(forecast: ForecastApiEntity)
        fun showDetailedWeatherInfo(weatherItem: WeatherListItem)
        fun showProgressBar()
    }
}
