package com.onboarding.pronosticAR.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onboarding.pronosticAR.R
import com.onboarding.pronosticAR.databinding.ItemWeatherBinding
import com.onboarding.pronosticAR.domain.entity.WeatherList
import com.onboarding.pronosticAR.utils.ConstantUtils
import com.onboarding.pronosticAR.utils.DateUtils
import com.onboarding.pronosticAR.utils.WindDirectionConverter

class WeatherAdapter(private val list: List<WeatherList>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(forecast: WeatherList) {
            with(ItemWeatherBinding.bind(itemView)) {
                textViewWeatherItemDay.text = DateUtils.getDate(forecast.dtTxt)
                textViewWeatherItemTemperature.text =
                    itemView.context.getString(
                        R.string.item_weather_text_view_temperature,
                        forecast.temperatureResponse.temperature.toString()
                    )
                textViewWeatherItemWind.text = itemView.context.getString(
                    R.string.item_weather_text_view_wind,
                    forecast.wind.speed.toString(),
                    WindDirectionConverter.getWindDirection(forecast.wind.deg)
                )
                textViewWeatherItemPrecipitation.text = itemView.context.getString(
                    R.string.item_weather_text_view_percentage_of_precipitation,
                    (forecast.pop * ConstantUtils.PERCENTAGE_ADJUST).toInt().toString()
                )
                Glide.with(itemView.context)
                    .load(itemView.context.getString(R.string.item_weather_image_view_url, forecast.descriptionResponse.first().icon))
                    .into(this.imageViewItemWeatherImage)
                this.imageViewItemWeatherImage.contentDescription = forecast.descriptionResponse.first().description
            }
        }
    }
}
