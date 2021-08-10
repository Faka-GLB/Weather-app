package com.onboarding.pronosticAR.mvp.view

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.pronosticAR.adapter.WeatherAdapter
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.databinding.ActivityMainBinding
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import com.onboarding.pronosticAR.mvp.view.base.ActivityView

class MainView(activity: Activity, private val binding: ActivityMainBinding) : ActivityView(activity), MainContract.MainView {

    override fun showWeather(forecast: ForecastApiEntity) {
        binding.recyclerViewMainActivity.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMainActivity.adapter = WeatherAdapter(forecast.list)
    }
}
