package com.onboarding.pronosticAR.data.service

import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

interface Service {
    fun getWeather(): Observable<ForecastApiEntity>
}
