package com.onboarding.pronosticAR.mvp.view

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.pronosticAR.adapter.WeatherAdapter
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.databinding.ActivityMainBinding
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import com.onboarding.pronosticAR.fragment.DetailedWeatherDialogFragment
import com.onboarding.pronosticAR.listener.WeatherItemClickListener
import com.onboarding.pronosticAR.mvp.view.base.ActivityView

class MainView(activity: Activity, private val binding: ActivityMainBinding, private val weatherItemClickListener: WeatherItemClickListener) : ActivityView(activity), MainContract.MainView {

    override fun showWeather(forecast: ForecastApiEntity) {
        binding.recyclerViewMainActivity.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMainActivity.adapter = WeatherAdapter(forecast.listItem, weatherItemClickListener)
    }

    override fun showDetailedWeatherInfo(bundle: Bundle) {
        val dialog = DetailedWeatherDialogFragment.newInstance(bundle)
        activity?.let {
            dialog.show((it as AppCompatActivity).supportFragmentManager, MAIN_VIEW_TAG)
        }
    }

    companion object{
        private const val MAIN_VIEW_TAG = "MainView"
    }
}
