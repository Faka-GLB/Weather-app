package com.onboarding.pronosticAR.mvp.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.onboarding.pronosticAR.contract.DetailedWeatherContract
import com.onboarding.pronosticAR.data.mapper.transform
import com.onboarding.pronosticAR.data.response.ListResponse
import org.junit.Before
import org.junit.Test

class DetailedWeatherPresenterTest {

    private lateinit var presenter: DetailedWeatherContract.DetailedWeatherPresenter
    private val view: DetailedWeatherContract.DetailedWeatherView = mock()

    @Before
    fun setUp() {
        presenter = DetailedWeatherPresenter(view)
    }

    @Test
    fun `init information` () {
        val weatherItem = ListResponse().transform()
        presenter.initInformation(weatherItem)
        verify(view).showDetailedWeatherInfo(weatherItem)
    }

    @Test
    fun `dismiss dialog` () {
        presenter.onReturnButtonPressed()
        verify(view).dismissFragment()
    }
}
