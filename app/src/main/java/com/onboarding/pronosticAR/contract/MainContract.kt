package com.onboarding.pronosticAR.contract

import com.onboarding.pronosticAR.domain.entity.ForecastApi
import io.reactivex.rxjava3.core.Observable

interface MainContract {

    interface MainPresenter {
        fun getWeatherInfo()
    }

    interface MainModel {
        fun getWeatherInfo(): Observable<ForecastApi>
    }

    interface MainView {
        fun showWeather(forecast: String, max: String, min :String)
    }
}
