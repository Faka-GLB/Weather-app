package com.onboarding.pronosticAR.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.data.WeatherService
import com.onboarding.pronosticAR.databinding.ActivityMainBinding
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.listener.WeatherItemClickListener
import com.onboarding.pronosticAR.mvp.model.MainModel
import com.onboarding.pronosticAR.mvp.presenter.MainPresenter
import com.onboarding.pronosticAR.mvp.view.MainView

class MainActivity : AppCompatActivity(), WeatherItemClickListener {
    private lateinit var presenter: MainContract.MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(model = MainModel(WeatherService()), view = MainView(this, binding, this))
        presenter.getWeatherInfo()
    }

    override fun onItemClick(weatherItem: WeatherListItem) {
        presenter.onWeatherItemPressed(weatherItem)
    }
}
