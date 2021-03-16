package com.mohsinali.appUtils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

fun getDefaultTimeZoneId(): String {
    val tz: TimeZone = TimeZone.getDefault()
    return tz.id
}

/**
 * Tries to return a time zone that would have had the specified offset
 * and DST value at the specified moment in the specified country.
 * Returns null if no suitable zone could be found.
 */
@RequiresApi(Build.VERSION_CODES.N) fun getTimeZone(
        offset: Int, dst: Boolean, `when`: Long, country: String?): TimeZone? {
    val icuTimeZone = getIcuTimeZone(offset, dst, `when`, country)
    // We must expose a java.util.TimeZone here for API compatibility because this is a public
    // API method.
    return if (icuTimeZone != null) TimeZone.getTimeZone(icuTimeZone.id) else null
}

@RequiresApi(Build.VERSION_CODES.N)
private fun getIcuTimeZone(
        offsetMillis: Int, isDst: Boolean, whenMillis: Long, countryIso: String?): android.icu.util.TimeZone? {
    if (countryIso == null) {
        return null
    }
    val bias = android.icu.util.TimeZone.getDefault()
    val countryTimeZones: CountryTimeZones = TimeZoneFinder.instance.lookupCountryTimeZones(countryIso)
            ?: return null
    val offsetResult: CountryTimeZones.OffsetResult = countryTimeZones.lookupByOffsetWithBias(
            whenMillis, bias, offsetMillis, isDst)!!
    return offsetResult.timeZone
}