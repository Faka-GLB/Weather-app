package com.onboarding.pronosticAR.utils

object WindDirectionConverter {
    fun getWindDirection(wind: Int) = when (wind) {
        in NORTHEAST_START..NORTHEAST_END -> NORTHEAST
        in EAST_START..EAST_END -> EAST
        in SOUTHEAST_START..SOUTHEAST_END -> SOUTHEAST
        in SOUTH_START..SOUTH_END -> SOUTH
        in SOUTHWEST_START..SOUTHWEST_END -> SOUTHWEST
        in WEST_START..WEST_END -> WEST
        in NORTHWEST_START..NORTHWEST_END -> NORTHWEST
        else -> NORTH
    }

    private const val NORTHEAST_START: Int = 21
    private const val NORTHEAST_END: Int = 69
    private const val EAST_START: Int = 70
    private const val EAST_END: Int = 110
    private const val SOUTHEAST_START: Int = 111
    private const val SOUTHEAST_END: Int = 159
    private const val SOUTH_START: Int = 160
    private const val SOUTH_END: Int = 200
    private const val SOUTHWEST_START: Int = 201
    private const val SOUTHWEST_END: Int = 249
    private const val WEST_START: Int = 250
    private const val WEST_END: Int = 290
    private const val NORTHWEST_START: Int = 291
    private const val NORTHWEST_END: Int = 339
    private const val NORTH: String = "N"
    private const val SOUTH: String = "S"
    private const val EAST: String = "E"
    private const val WEST: String = "O"
    private const val NORTHEAST: String = "NE"
    private const val NORTHWEST: String = "NO"
    private const val SOUTHEAST: String = "SE"
    private const val SOUTHWEST: String = "SO"
}
