package com.onboarding.pronosticAR.contract

import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

interface MainContract {

    interface MainPresenter {
        fun getWeatherInfo()
    }

    interface MainModel {
        fun getWeatherInfo(): Observable<ForecastApiEntity>
    }

    interface MainView {
        fun showWeather(forecast: ForecastApiEntity)
    }
}
