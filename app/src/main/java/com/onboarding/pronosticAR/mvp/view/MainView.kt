package com.onboarding.pronosticAR.mvp.view

import android.app.Activity
import android.widget.Toast
import com.onboarding.pronosticAR.R
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.mvp.view.base.ActivityView

class MainView(activity: Activity) : ActivityView(activity), MainContract.MainView {
    override fun showWeather(forecast: String, max: String, min: String) {
        activity?.let {
            Toast.makeText(it, it.getString(R.string.main_activity_show_weather_toast, forecast, max, min), Toast.LENGTH_LONG).show()
        }
    }
}
