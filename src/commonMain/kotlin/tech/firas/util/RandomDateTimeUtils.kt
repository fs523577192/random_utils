/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.firas.util

import kotlin.random.Random
import kotlin.jvm.JvmStatic

/**
 *
 * @author Wu Yuping
 */
class RandomDateTimeUtils(private val random: Random) {

    companion object {
        val monthName = mapOf(
                Pair("en", listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")),
                Pair("zh", listOf("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"))
        )
        val weekDayName = mapOf(
                Pair("en", listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")),
                Pair("zh", listOf("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"))
        )

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

    /**
     * @return an integer between 1 (inclusive) and 12 (inclusive)
     */
    fun randomMonth(): Int {
        return this.basicUtils.randomInt(1, 12)
    }
    fun randomEnglishMonth(): String {
        return monthName["en"]!![this.random.nextInt(12)]
    }
    fun randomEnglishMonthShort(): String {
        return this.randomEnglishMonth().substring(0, 3)
    }
    fun randomChineseMonth(): String {
        return monthName["zh"]!![this.random.nextInt(12)]
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

    /**
     * @return an integer between 0 (inclusive) and 7 (exclusive)
     */
    fun randomDayOfWeek(): Int {
        return this.random.nextInt(7)
    }
    fun randomEnglishDayOfWeek(): String {
        return weekDayName["en"]!![this.random.nextInt(7)]
    }
    fun randomEnglishDayOfWeekShort(): String {
        return this.randomEnglishDayOfWeek().substring(0, 3)
    }
    fun randomChineseDayOfWeek(): String {
        return weekDayName["zh"]!![this.random.nextInt(7)]
    }

    /**
     * @return an integer between 0 (inclusive) and 24 (exclusive)
     */
    fun randomHour24(): Int {
        return this.random.nextInt(24)
    }

    /**
     * @return an integer between 0 (inclusive) and 60 (exclusive)
     */
    fun randomMinuteOrSecond(): Int {
        return this.random.nextInt(60)
    }
}