package com.onboarding.pronosticAR.utils

object DateUtils {
    fun getDate(date: String) = String.format(
        FORMAT,
        date.substring(STRING_DAY_START, STRING_DAY_END),
        date.substring(STRING_MONTH_START, STRING_MONTH_END),
        date.substring(STRING_HOUR_START, STRING_HOUR_END)
    )

    private const val FORMAT = "%s/%s %s:00"
    private const val STRING_DAY_START: Int = 8
    private const val STRING_DAY_END: Int = 10
    private const val STRING_MONTH_START: Int = 5
    private const val STRING_MONTH_END: Int = 7
    private const val STRING_HOUR_START: Int = 11
    private const val STRING_HOUR_END: Int = 13
}
