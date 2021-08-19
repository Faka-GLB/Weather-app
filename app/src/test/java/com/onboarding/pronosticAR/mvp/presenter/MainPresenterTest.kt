package com.onboarding.pronosticAR.mvp.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.onboarding.pronosticAR.contract.MainContract
import com.onboarding.pronosticAR.data.mapper.transform
import com.onboarding.pronosticAR.data.response.ApiResponse
import com.onboarding.pronosticAR.data.response.ListResponse
import com.onboarding.pronosticAR.data.service.WeatherServiceI
import com.onboarding.pronosticAR.mvp.model.MainModel
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.TimeUnit

class MainPresenterTest {
    private lateinit var presenter: MainContract.MainPresenter
    private val service: WeatherServiceI = mock()
    private lateinit var model: MainContract.MainModel
    private val view: MainContract.MainView = mock()
    private val emptyApiEntity = ApiResponse().transform()

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        whenever(service.getWeather()).thenReturn(Observable.just(emptyApiEntity))
        model = MainModel(service)
        presenter = MainPresenter(model, view)
    }

    @Test
    fun `get weather info test`() {
        presenter.getWeatherInfo()
        verify(view).showProgressBar()
        verify(view).showWeather(emptyApiEntity)
        assertEquals(service.getWeather(), model.getWeatherInfo())
    }

    @Test
    fun `on weather item pressed test` (){
        val weatherItem = ListResponse().transform()
        presenter.onWeatherItemPressed(weatherItem)
        verify(view).showDetailedWeatherInfo(weatherItem)
    }

    companion object {
        private const val NO_DELAY: Long = 0

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
                    return super.scheduleDirect(run, NO_DELAY, unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker({ it.run() }, true, true)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }
}
