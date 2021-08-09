package com.onboarding.pronosticAR.data

import com.onboarding.pronosticAR.data.api.WeatherApi
import com.onboarding.pronosticAR.data.mapper.transform
import com.onboarding.pronosticAR.data.service.WeatherRequestGenerator
import com.onboarding.pronosticAR.domain.entity.ForecastApi
import io.reactivex.rxjava3.core.Observable

class WeatherService {
    private val generator = WeatherRequestGenerator()

    fun getWeather(): Observable<ForecastApi> {
        return Observable.create { subscriber ->
            val callResponse =
                generator.createService(WeatherApi::class.java).callWeatherInfo(CITY, APP_ID, UNITS)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body()?.transform())
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val CITY: String = "Tandil"
        private const val APP_ID: String = "ff9d1c20c2cd49638fe55fcc5de49940"
        private const val UNITS: String = "metric"
    }
}
