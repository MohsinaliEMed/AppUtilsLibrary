package com.mohsinali.appUtils

import android.icu.util.TimeZone
import android.os.Build
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.ArrayList


class CountryTimeZones internal constructor(private val mDelegate: CountryTimeZones) {
    /**
     * A mapping to a time zone ID with some associated metadata.
     *
     * @hide
     */
    class TimeZoneMapping internal constructor(delegate: TimeZoneMapping?) {
        private val mDelegate: TimeZoneMapping = Objects.requireNonNull(delegate)!!

        /**
         * Returns the ID for this mapping. The ID is a tzdb time zone identifier like
         * "America/Los_Angeles" that can be used with methods such as [ ][TimeZone.getFrozenTimeZone]. See [.getTimeZone] which returns a frozen
         * [TimeZone] object.
         */
        val timeZoneId: String
            get() = mDelegate.timeZoneId

        /**
         * Returns a frozen [TimeZone] object for this mapping.
         */
        val timeZone: TimeZone
            get() = mDelegate.timeZone

        override fun equals(o: Any?): Boolean {
            if (this === o) {
                return true
            }
            if (o == null || javaClass != o.javaClass) {
                return false
            }
            val that = o as TimeZoneMapping
            return mDelegate.equals(that.mDelegate)
        }

        override fun hashCode(): Int {
            return mDelegate.hashCode()
        }

        override fun toString(): String {
            return mDelegate.toString()
        }

    }

    /**
     * The result of lookup up a time zone using offset information (and possibly more).
     *
     * @hide
     */
    class OffsetResult(timeZone: TimeZone, isOnlyMatch: Boolean) {
        private val mTimeZone: TimeZone

        /**
         * Returns `true` if there is only one matching time zone for the supplied criteria.
         */
        val isOnlyMatch: Boolean

        /**
         * Returns a time zone that matches the supplied criteria.
         */
        val timeZone: TimeZone
            get() = mTimeZone

        @RequiresApi(Build.VERSION_CODES.N)
        override fun equals(o: Any?): Boolean {
            if (this === o) {
                return true
            }
            if (o == null || javaClass != o.javaClass) {
                return false
            }
            val that = o as OffsetResult
            return (isOnlyMatch == that.isOnlyMatch
                    && mTimeZone.id.equals(that.mTimeZone.id))
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun hashCode(): Int {
            return Objects.hash(mTimeZone, isOnlyMatch)
        }

        @RequiresApi(Build.VERSION_CODES.N)
        override fun toString(): String {
            return ("OffsetResult{"
                    + "mTimeZone(ID)=" + mTimeZone.id
                    + ", mIsOnlyMatch=" + isOnlyMatch
                    + '}')
        }

        /** Creates an instance with the supplied information.  */
        init {
            mTimeZone = Objects.requireNonNull(timeZone)
            this.isOnlyMatch = isOnlyMatch
        }
    }

    /**
     * Returns true if the ISO code for the country is a case-insensitive match for the one
     * supplied.
     */
    fun matchesCountryCode(countryIso: String): Boolean {
        return mDelegate.matchesCountryCode(countryIso)
    }

    /**
     * Returns the default time zone ID for the country. Can return `null` in cases when no
     * data is available or the time zone ID was not recognized.
     */
    @get:Nullable val defaultTimeZoneId: String
        get() = mDelegate.defaultTimeZoneId

    /**
     * Returns the default time zone for the country. Can return `null` in cases when no data
     * is available or the time zone ID was not recognized.
     */
    @get:Nullable val defaultTimeZone: TimeZone
        get() = mDelegate.defaultTimeZone

    /**
     * Qualifier for a country's default time zone. `true` indicates that the country's
     * default time zone would be a good choice *generally* when there's no UTC offset
     * information available. This will only be `true` in countries with multiple zones where
     * a large majority of the population is covered by only one of them.
     */
    val isDefaultTimeZoneBoosted: Boolean
        get() = mDelegate.isDefaultTimeZoneBoosted

    /**
     * Returns `true` if the country has at least one time zone that uses UTC at the given
     * time. This is an efficient check when trying to validate received UTC offset information.
     * For example, there are situations when a detected zero UTC offset cannot be distinguished
     * from "no information available" or a corrupted signal. This method is useful because checking
     * offset information for large countries is relatively expensive but it is generally only the
     * countries close to the prime meridian that use UTC at *any* time of the year.
     *
     * @param whenMillis the time the offset information is for in milliseconds since the beginning
     * of the Unix epoch
     */
    fun hasUtcZone(whenMillis: Long): Boolean {
        return mDelegate.hasUtcZone(whenMillis)
    }

    /**
     * Returns a time zone for the country, if there is one, that matches the supplied properties.
     * If there are multiple matches and the `bias` is one of them then it is returned,
     * otherwise an arbitrary match is returned based on the [ ][.getEffectiveTimeZoneMappingsAt] ordering.
     *
     * @param whenMillis the UTC time to match against
     * @param bias the time zone to prefer, can be `null` to indicate there is no preference
     * @param totalOffsetMillis the offset from UTC at `whenMillis`
     * @param isDst the Daylight Savings Time state at `whenMillis`. `true` means DST,
     * `false` means not DST
     * @return an [OffsetResult] with information about a matching zone, or `null` if
     * there is no match
     */
    @Nullable fun lookupByOffsetWithBias(whenMillis: Long, @Nullable bias: android.icu.util.TimeZone,
                                         totalOffsetMillis: Int, isDst: Boolean): OffsetResult? {
        val delegateOffsetResult = mDelegate.lookupByOffsetWithBias(
                whenMillis, bias, totalOffsetMillis, isDst)
        return if (delegateOffsetResult == null) null else OffsetResult(
                delegateOffsetResult.timeZone, delegateOffsetResult.isOnlyMatch)
    }

    /**
     * Returns a time zone for the country, if there is one, that matches the supplied properties.
     * If there are multiple matches and the `bias` is one of them then it is returned,
     * otherwise an arbitrary match is returned based on the [ ][.getEffectiveTimeZoneMappingsAt] ordering.
     *
     * @param whenMillis the UTC time to match against
     * @param bias the time zone to prefer, can be `null` to indicate there is no preference
     * @param totalOffsetMillis the offset from UTC at `whenMillis`
     * @return an [OffsetResult] with information about a matching zone, or `null` if
     * there is no match
     */
    @Nullable fun lookupByOffsetWithBias(whenMillis: Long, @Nullable bias: TimeZone?,
                                         totalOffsetMillis: Int): OffsetResult? {
        val delegateOffsetResult = mDelegate.lookupByOffsetWithBias(whenMillis, bias, totalOffsetMillis)
        return if (delegateOffsetResult == null) null else OffsetResult(
                delegateOffsetResult.timeZone, delegateOffsetResult.isOnlyMatch)
    }

    /**
     * Returns an immutable, ordered list of time zone mappings for the country in an undefined but
     * "priority" order, filtered so that only "effective" time zone IDs are returned. An
     * "effective" time zone is one that differs from another time zone used in the country after
     * `whenMillis`. The list can be empty if there were no zones configured or the configured
     * zone IDs were not recognized.
     */
    fun getEffectiveTimeZoneMappingsAt(whenMillis: Long): List<TimeZoneMapping> {
        val delegateList = mDelegate.getEffectiveTimeZoneMappingsAt(whenMillis)
        val toReturn: MutableList<TimeZoneMapping> = ArrayList(delegateList.size)
        for (delegateMapping in delegateList) {
            toReturn.add(TimeZoneMapping(delegateMapping))
        }
        return Collections.unmodifiableList(toReturn)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as CountryTimeZones
        return mDelegate.equals(that.mDelegate)
    }

    override fun hashCode(): Int {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            Objects.hash(mDelegate)
        } else {
            TODO("VERSION.SDK_INT < KITKAT")
        }
    }

    override fun toString(): String {
        return mDelegate.toString()
    }
}