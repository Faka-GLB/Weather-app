package com.onboarding.pronosticAR.mvp.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.pronosticAR.adapter.WeatherAdapter
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.databinding.ActivityMainBinding
import com.onboarding.pronosticAR.domain.entity.ForecastApiEntity
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.fragment.DetailedWeatherDialogFragment
import com.onboarding.pronosticAR.listener.WeatherItemClickListener
import com.onboarding.pronosticAR.mvp.view.base.ActivityView
import com.onboarding.pronosticAR.utils.ConstantUtils

class MainView(
    activity: Activity,
    private val binding: ActivityMainBinding,
    private val weatherItemClickListener: WeatherItemClickListener
) : ActivityView(activity), MainContract.MainView {

    override fun showWeather(forecast: ForecastApiEntity) {
        binding.progressBarMainActivity.visibility = View.GONE
        binding.recyclerViewMainActivity.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMainActivity.adapter = WeatherAdapter(forecast.listItem, weatherItemClickListener)
    }

    override fun showDetailedWeatherInfo(weatherItem: WeatherListItem) {
        val bundle = Bundle()
        bundle.putParcelable(ConstantUtils.WEATHER_TAG, weatherItem)
        val dialog = DetailedWeatherDialogFragment.newInstance(bundle)
        activity?.let {
            dialog.show((it as AppCompatActivity).supportFragmentManager, MAIN_VIEW_TAG)
        }
    }

    override fun showProgressBar() {
        binding.progressBarMainActivity.visibility = View.VISIBLE
    }

    companion object {
        private const val MAIN_VIEW_TAG = "MainView"
    }
}
