package com.onboarding.pronosticAR.mvp.view

import androidx.fragment.app.DialogFragment
import com.onboarding.pronosticAR.R
import com.onboarding.pronosticAR.contract.DetailedWeatherContract
import com.onboarding.pronosticAR.databinding.DetailedWeatherFragmentBinding
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.mvp.view.base.FragmentView
import com.onboarding.pronosticAR.utils.DateUtils

class DetailedWeatherView(fragment: DialogFragment, private val binding: DetailedWeatherFragmentBinding) : FragmentView(fragment),
    DetailedWeatherContract.DetailedWeatherView {
    override fun showDetailedWeatherInfo(weatherItem: WeatherListItem) {
        context?.let {
            weatherItem.let { weather ->
                binding.textViewDetailedWeatherFragmentTitle.text = DateUtils.getDate(weather.dtTxt)
                binding.textViewDetailedWeatherFragmentDescription.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_description, weather.descriptionResponse.first().description)
                binding.textViewDetailedWeatherFragmentFeelsLikeTemperature.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_feels_like, weather.temperatureResponse.feelsLike)
                binding.textViewDetailedWeatherFragmentMinimumTemperature.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_minimum, weather.temperatureResponse.min)
                binding.textViewDetailedWeatherFragmentMaximumTemperature.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_maximum, weather.temperatureResponse.max)
                binding.textViewDetailedWeatherFragmentHumidity.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_humidity, weather.temperatureResponse.humidity)
                binding.textViewDetailedWeatherFragmentAtmosphericPressure.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_pressure, weather.temperatureResponse.pressure)
                binding.textViewDetailedWeatherFragmentCloudness.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_cloudness, weather.clouds.all)
                binding.textViewDetailedWeatherFragmentVisibility.text =
                    it.getString(R.string.detailed_weather_fragment_text_view_visibility, weather.visibility)
            }
        }
    }

    override fun dismissFragment() {
        (fragment as DialogFragment).dismiss()
    }
}
