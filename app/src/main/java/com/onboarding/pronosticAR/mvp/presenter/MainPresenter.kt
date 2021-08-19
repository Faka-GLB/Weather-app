package com.onboarding.pronosticAR.mvp.presenter

import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(private val model: MainContract.MainModel, private val view: MainContract.MainView) : MainContract.MainPresenter {

    override fun getWeatherInfo() {
        view.showProgressBar()
        model.getWeatherInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { weather -> view.showWeather(weather) }
    }

    override fun onWeatherItemPressed(weatherItem: WeatherListItem) {
        view.showDetailedWeatherInfo(weatherItem)
    }
}
