package com.onboarding.pronosticAR.listener

import com.onboarding.pronosticAR.domain.entity.WeatherListItem

interface WeatherItemClickListener {
    fun onItemClick(weatherItem: WeatherListItem)
}
