package com.onboarding.pronosticAR.data.mapper

import com.onboarding.pronosticAR.data.response.ApiResponse
import com.onboarding.pronosticAR.data.response.CityResponse
import com.onboarding.pronosticAR.data.response.CloudResponse
import com.onboarding.pronosticAR.data.response.CoordResponse
import com.onboarding.pronosticAR.data.response.ListResponse
import com.onboarding.pronosticAR.data.response.RainResponse
import com.onboarding.pronosticAR.data.response.SysResponse
import com.onboarding.pronosticAR.data.response.TemperatureResponse
import com.onboarding.pronosticAR.data.response.WeatherResponse
import com.onboarding.pronosticAR.data.response.WindResponse
import com.onboarding.pronosticAR.domain.entity.City
import com.onboarding.pronosticAR.domain.entity.Cloud
import com.onboarding.pronosticAR.domain.entity.Coordinates
import com.onboarding.pronosticAR.domain.entity.MainTemperature
import com.onboarding.pronosticAR.domain.entity.Rain
import com.onboarding.pronosticAR.domain.entity.Sys
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import com.onboarding.pronosticAR.domain.entity.WeatherDescription
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.domain.entity.Wind

fun ApiResponse.transform() = ForecastApiEntity(
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    listItem = this.list.transform(),
    city = this.city.transform()
)

fun List<ListResponse>.transform() = this.map { it.transform() }

fun ListResponse.transform() = WeatherListItem(
    dt = this.date,
    temperatureResponse = this.mainResponse.transform(),
    descriptionResponse = this.weatherResponse.map { it.transform() },
    clouds = this.clouds.transform(),
    wind = this.wind.transform(),
    visibility = this.visibility,
    pop = this.pop,
    rain = this.rain.transform(),
    sys = this.sys.transform(),
    dtTxt = this.dtTxt
)

fun TemperatureResponse.transform() = MainTemperature(
    temperature = this.temperature,
    feelsLike = this.feelsLike,
    min = this.minimum,
    max = this.maximum,
    pressure = this.pressure,
    seaLevel = this.seaLevel,
    groundLevel = this.groundLevel,
    humidity = this.humidity,
    tempKf = this.tempKf
)

fun WeatherResponse.transform() = WeatherDescription(
    id = this.id,
    weather = this.weather,
    description = this.description,
    icon = this.icon
)

fun CloudResponse.transform() = Cloud(all = this.all)

fun WindResponse.transform() = Wind(speed = this.speed, deg = this.deg, gust = this.gust)

fun RainResponse.transform() = Rain(h = this.h)

fun SysResponse.transform() = Sys(pod = this.pod)

fun CityResponse.transform() = City(
    id = this.id,
    name = this.name,
    coord = this.coordinates.transform(),
    country = this.country,
    population = this.population,
    timezone = this.timezone,
    sunrise = this.sunrise,
    sunset = this.sunset
)

fun CoordResponse.transform() = Coordinates(lat = this.latitude, lon = this.longitude)
