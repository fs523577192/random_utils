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
class ChineseRelatedRandomUtils(private val random: Random) {

    companion object {

        private val singleton = ChineseRelatedRandomUtils(Random.Default)

        @JvmStatic
        fun getDefault(): ChineseRelatedRandomUtils {
            return singleton
        }
    }

    private val basicUtils = if (Random.Default == this.random) BasicRandomUtils.getDefault()
                            else BasicRandomUtils(this.random)
    private val randomStringUtils = if (Random.Default == this.random) RandomStringUtils.getDefault()
                            else RandomStringUtils(this.random)
    private val randomDateTimeUtils = if (Random.Default == this.random) RandomDateTimeUtils.getDefault()
                            else RandomDateTimeUtils(this.random)

    /* --== Mobile number ==-- */
    fun randomChineseMobile(): String {
        return "1" + ('0'.toInt() + this.basicUtils.randomInt(3, 9)).toChar() +
                this.randomStringUtils.randomNumericString(9, 9)
    }

    /**
     * 中国移动手机号码段（2019）
     */
    private val chineseMobileRange = arrayOf("134", "135", "136", "137", "138", "139",
            "147", "148", "150", "151", "152", "157", "158", "159", "165", "172", "178",
            "182", "183", "184", "187", "188", "198")
    /**
     * 中国电信手机号码段（2019）
     */
    private val chineseTelecomRange = arrayOf("133", "149", "153", "173", "174", "177",
            "180", "181", "189", "191", "193", "199")
    /**
     * 中国联通手机号码段（2019）
     */
    private val chineseUnicomRange = arrayOf("130", "131", "132", "145", "146", "155", "156", "166",
            "175", "176", "185", "186")

    fun randomChineseMobileStrict(): String {
        val i = this.random.nextInt(chineseMobileRange.size + chineseTelecomRange.size + chineseUnicomRange.size)
        val prefix = when {
            i < chineseMobileRange.size ->
                chineseMobileRange[i]
            i < chineseMobileRange.size + chineseTelecomRange.size ->
                chineseTelecomRange[i - chineseMobileRange.size]
            else ->
                chineseUnicomRange[i - (chineseMobileRange.size + chineseTelecomRange.size)]
        }
        return prefix + this.randomStringUtils.randomNumericString(8, 8)
    }

    fun randomChineseIdCardNumber(): String {
        val i = this.random.nextInt(_ChineseIdCardPrefix.size)
        val prefix = _ChineseIdCardPrefix[i]

        val year = this.basicUtils.randomInt(1910, 2019)
        val month = this.randomDateTimeUtils.randomMonth()
        val dayOfMonth = this.randomDateTimeUtils.randomDayOfMonth(month, year)
        val birthday = "$year" + ensureTwoDigits(month) + ensureTwoDigits(dayOfMonth)

        val suffix = this.randomStringUtils.randomNumericString(3, 3)
        val merged = "$prefix$birthday$suffix"
        var sum = 0
        for (i in 0 until idCardCoef.size) {
            sum += (merged[i].toInt() - '0'.toInt()) * idCardCoef[i]
        }
        val checkSum = idCardcheckNumberArray[sum % idCardcheckNumberArray.size]
        return "$merged$checkSum"
    }

    private val idCardCoef = intArrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)
    private val idCardcheckNumberArray = charArrayOf('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2')
    private fun ensureTwoDigits(n: Int): String {
        return if (n >= 10) n.toString() else ("0$n")
    }
}

expect internal val _ChineseIdCardPrefix: List<String>
