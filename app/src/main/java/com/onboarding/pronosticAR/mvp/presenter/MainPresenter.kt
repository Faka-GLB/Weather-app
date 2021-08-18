package com.onboarding.pronosticAR.mvp.presenter

import android.os.Bundle
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.utils.ConstantUtils.WEATHER_TAG
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(private val model: MainContract.MainModel, private val view: MainContract.MainView) : MainContract.MainPresenter {

    init {
        getWeatherInfo()
    }

    override fun getWeatherInfo() {
        view.showProgressBar()
        model.getWeatherInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { weather -> view.showWeather(weather) }
    }

    override fun onWeatherItemPressed(weatherItem: WeatherListItem) {
        val bundle = Bundle()
        bundle.putParcelable(WEATHER_TAG, weatherItem)
        view.showDetailedWeatherInfo(bundle)
    }
}
