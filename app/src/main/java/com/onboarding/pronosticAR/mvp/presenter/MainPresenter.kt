package com.onboarding.pronosticAR.mvp.presenter

import com.onboarding.pronosticAR.contract.MainContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(private val model: MainContract.MainModel, private val view: MainContract.MainView) : MainContract.MainPresenter {

    init {
        getWeatherInfo()
    }

    override fun getWeatherInfo() {
        model.getWeatherInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { weather ->
                val current = weather.list.first()
                view.showWeather(
                    current.descriptionResponse.first().weather,
                    current.temperatureResponse.max.toString(),
                    current.temperatureResponse.min.toString()
                )
            }
    }
}
