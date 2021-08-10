package com.onboarding.pronosticAR.data

import com.onboarding.pronosticAR.BuildConfig.APP_ID
import com.onboarding.pronosticAR.data.api.WeatherApi
import com.onboarding.pronosticAR.data.mapper.transform
import com.onboarding.pronosticAR.data.service.WeatherRequestGenerator
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

class WeatherService {
    private val generator = WeatherRequestGenerator()

    fun getWeather(): Observable<ForecastApiEntity> {
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
        private const val UNITS: String = "metric"
    }
}
