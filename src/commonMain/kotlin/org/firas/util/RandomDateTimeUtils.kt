package org.firas.util

import kotlin.random.Random
import kotlin.jvm.JvmStatic

/**
 *
 * @author Wu Yuping
 */
class RandomDateTimeUtils(private val random: Random) {

    companion object {

        private val singleton = RandomDateTimeUtils(Random.Default)

        @JvmStatic
        fun getDefault(): RandomDateTimeUtils {
            return singleton
        }

        private fun isLeapYear(year: Int): Boolean {
            return year % ( if (year % 100 == 0) 400 else 4 ) == 0
        }
    }

    private val basicUtils = if (Random.Default == this.random) BasicRandomUtils.getDefault()
                            else BasicRandomUtils(this.random)

    fun randomMonth(): Int {
        return this.basicUtils.randomInt(1, 12)
    }

    fun randomDayOfMonth(month: Int, isLeap: Boolean): Int {
        return this.basicUtils.randomInt(1, when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11           -> 30
            2                     -> if (isLeap) 29 else 28
            else -> throw IllegalArgumentException("The month should be 1 to 12: $month")
        })
    }
    fun randomDayOfMonth(month: Int, year: Int): Int {
        return this.randomDayOfMonth(month, isLeapYear(year))
    }

    fun randomHour24(): Int {
        return this.random.nextInt(24)
    }

    fun randomMinuteOrSecond(): Int {
        return this.random.nextInt(60)
    }
}