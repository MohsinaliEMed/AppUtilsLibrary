package com.mohsinali.appUtils

import androidx.annotation.GuardedBy
import androidx.annotation.Nullable
import java.util.*


class TimeZoneFinder private constructor(delegate: TimeZoneFinder) {
    private val mDelegate: TimeZoneFinder = Objects.requireNonNull(delegate)

    /**
     * Returns the IANA rules version associated with the data. If there is no version information
     * or there is a problem reading the file then `null` is returned.
     */
    @get:Nullable val ianaVersion: String
        get() = mDelegate.ianaVersion

    /**
     * Returns a [CountryTimeZones] object associated with the specified country code.
     * Caching is handled as needed. If the country code is not recognized or there is an error
     * during lookup this method can return null.
     */
    @Nullable fun lookupCountryTimeZones(countryIso: String): CountryTimeZones? {
        val delegate = mDelegate
                .lookupCountryTimeZones(countryIso)
        return delegate?.let { CountryTimeZones(it) }
    }

    companion object {
        private val sLock = Any()

        @GuardedBy("sLock")
        private var sInstance: TimeZoneFinder? = null

        /**
         * Obtains the singleton instance.
         */
        val instance: TimeZoneFinder
            get() {
                synchronized(sLock) {
                    if (sInstance == null) {
                        sInstance = TimeZoneFinder(TimeZoneFinder.instance)
                    }
                }
                return sInstance!!
            }
    }

}