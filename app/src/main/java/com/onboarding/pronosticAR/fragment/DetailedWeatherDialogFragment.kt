package com.onboarding.pronosticAR.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.onboarding.pronosticAR.contract.DetailedWeatherContract
import com.onboarding.pronosticAR.data.mapper.transform
import com.onboarding.pronosticAR.data.response.ListResponse
import com.onboarding.pronosticAR.databinding.DetailedWeatherFragmentBinding
import com.onboarding.pronosticAR.domain.entity.WeatherListItem
import com.onboarding.pronosticAR.mvp.presenter.DetailedWeatherPresenter
import com.onboarding.pronosticAR.mvp.view.DetailedWeatherView
import com.onboarding.pronosticAR.utils.ConstantUtils.WEATHER_TAG

class DetailedWeatherDialogFragment : DialogFragment() {
    private lateinit var binding: DetailedWeatherFragmentBinding
    private lateinit var presenter: DetailedWeatherContract.DetailedWeatherPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        this.binding = DetailedWeatherFragmentBinding.inflate(layoutInflater)
        this.presenter = DetailedWeatherPresenter(view = DetailedWeatherView(this, binding))
        arguments?.getParcelable<WeatherListItem>(WEATHER_TAG).let {
            presenter.initInformation(it ?: ListResponse().transform())
        }
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.buttonDetailedWeatherFragmentReturn.setOnClickListener { presenter.onReturnButtonPressed() }
    }

    companion object {
        fun newInstance(args: Bundle): DetailedWeatherDialogFragment {
            val fragment = DetailedWeatherDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
