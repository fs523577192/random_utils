package org.firas.util

import kotlin.jvm.JvmStatic
import kotlin.random.Random

class RandomUtils {
    companion object {
        /**
         * @param min lower bound (inclusive)
         * @param max upper bound (inclusive)
         */
        @JvmStatic
        fun randomInt(min: Int, max: Int): Int {
            return Random.Default.nextInt(min, max + 1)
        }

        @JvmStatic
        fun randomAsciiChar(): Char {
            return randomInt(' '.toInt(), '~'.toInt()).toChar()
        }

        @JvmStatic
        fun randomUpperCaseAlphabet(): Char {
            return randomInt('A'.toInt(), 'Z'.toInt()).toChar()
        }

        @JvmStatic
        fun randomLowerCaseAlphabet(): Char {
            return randomInt('a'.toInt(), 'z'.toInt()).toChar()
        }

        @JvmStatic
        fun randomAlphabet(): Char {
            return if (Random.Default.nextBoolean()) randomUpperCaseAlphabet() else randomLowerCaseAlphabet()
        }

        @JvmStatic
        fun randomDigit(): Char {
            return randomInt('0'.toInt(), '9'.toInt()).toChar()
        }

        @JvmStatic
        fun randomUpperCaseAlphanumeric(): Char {
            val n = Random.Default.nextInt(10 + 26)
            return if (n < 10) ('0'.toInt() + n).toChar()
                    else ('A'.toInt() + n - 10).toChar()
        }

        @JvmStatic
        fun randomLowerCaseAlphanumeric(): Char {
            val n = Random.Default.nextInt(10 + 26)
            return if (n < 10) ('0'.toInt() + n).toChar()
                    else ('a'.toInt() + n - 10).toChar()
        }

        @JvmStatic
        fun randomAlphanumeric(): Char {
            val n = Random.Default.nextInt(10 + 26 + 26)
            return when {
                n < 10        -> ('0'.toInt() + n).toChar()
                n < (10 + 26) -> ('A'.toInt() + n - 10).toChar()
                else          -> ('a'.toInt() + n - (10 + 26)).toChar()
            }
        }

        @JvmStatic
        fun randomAsciiString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomAsciiChar())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomAsciiString(maxLength: Int): String {
            return randomAsciiString(0, maxLength)
        }

        @JvmStatic
        fun randomUpperCaseAlphabetString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomUpperCaseAlphabet())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomUpperCaseAlphabetString(maxLength: Int): String {
            return randomUpperCaseAlphabetString(0, maxLength)
        }

        @JvmStatic
        fun randomLowerCaseAlphabetString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomLowerCaseAlphabet())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomLowerCaseAlphabetString(maxLength: Int): String {
            return randomLowerCaseAlphabetString(0, maxLength)
        }

        @JvmStatic
        fun randomAlphabetString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomAlphabet())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomAlphabetString(maxLength: Int): String {
            return randomAlphabetString(0, maxLength)
        }

        @JvmStatic
        fun randomDigitString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomDigit())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomDigitString(maxLength: Int): String {
            return randomDigitString(0, maxLength)
        }

        @JvmStatic
        fun randomUpperCaseAlphanumericString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomUpperCaseAlphanumeric())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomUpperCaseAlphanumericString(maxLength: Int): String {
            return randomUpperCaseAlphanumericString(0, maxLength)
        }

        @JvmStatic
        fun randomLowerCaseAlphanumericString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomLowerCaseAlphanumeric())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomLowerCaseAlphanumericString(maxLength: Int): String {
            return randomLowerCaseAlphanumericString(0, maxLength)
        }

        @JvmStatic
        fun randomAlphanumericString(minLength: Int, maxLength: Int): String {
            checkMinLength(minLength)
            val length = randomInt(minLength, maxLength)
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomAlphanumeric())
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomAlphanumericString(maxLength: Int): String {
            return randomAlphanumericString(0, maxLength)
        }

        /**
         * A C / C++ / Java identifier contains only alphanumeric characters and underscore('_')
         * and does NOT start with a digit
         * @param minLength the minimum length of the generated String,
         *                   cannot be less than 1 as a C identifier cannot be an empty string
         * @param maxLength the maximum length of the generated String
         * @return a C / C++ / Java idendifier that is randomly generated
         */
        @JvmStatic
        fun randomCIdentifier(minLength: Int, maxLength: Int): String {
            if (minLength < 1) {
                throw IllegalArgumentException("minLength should be positive: $minLength")
            }
            val builder = StringBuilder()
            var n = randomInt(0, 26 * 2)
            builder.append(when {
                n < 26     -> ('A'.toInt() + n).toChar()
                n < 26 * 2 -> ('a'.toInt() + n - 26).toChar()
                else -> '_'
            })

            val length = randomInt(minLength - 1, maxLength - 1)
            for (i in 0 until length) {
                n = randomInt(0, 26 * 2 + 10)
                builder.append(when {
                    n < 10            -> ('0'.toInt() + n).toChar()
                    n < (26 + 10)     -> ('A'.toInt() + n - 10).toChar()
                    n < (26 * 2 + 10) -> ('a'.toInt() + n - (26 + 10)).toChar()
                    else              -> '_'
                })
            }
            return builder.toString()
        }

        @JvmStatic
        fun randomCIdentifier(maxLength: Int): String {
            return randomCIdentifier(1, maxLength)
        }

        /* --== Mobile number ==-- */
        @JvmStatic
        fun randomChineseMobile(): String {
            return "1" + ('0'.toInt() + randomInt(3, 9)).toChar() + randomDigitString(9, 9)
        }

        /**
         * 中国移动手机号码段（2019）
         */
        private val chineseMobileRange = arrayOf("134", "135", "136", "137", "138",
                "150", "151", "152", "157", "158", "159", "165", "172", "178",
                "182", "183", "184", "187", "188", "198")
        /**
         * 中国电信手机号码段（2019）
         */
        private val chineseTelecomRange = arrayOf("133", "149", "153", "173", "174", "177",
                "180", "181", "189", "191", "199")
        /**
         * 中国联通手机号码段（2019）
         */
        private val chineseUnicomRange = arrayOf("130", "131", "132", "155", "156", "166",
                "171", "175", "176", "185", "186")

        @JvmStatic
        fun randomChineseMobileStrict(): String {
            val i = Random.Default.nextInt(chineseMobileRange.size + chineseTelecomRange.size + chineseUnicomRange.size)
            val prefix = when {
                i < chineseMobileRange.size ->
                    chineseMobileRange[i]
                i < chineseMobileRange.size + chineseTelecomRange.size ->
                    chineseTelecomRange[i - chineseMobileRange.size]
                else ->
                    chineseUnicomRange[i - (chineseMobileRange.size + chineseTelecomRange.size)]
            }
            return prefix + randomDigitString(8, 8)
        }

        /* --== Date and time ==-- */
        @JvmStatic
        fun randomMonth(): Int {
            return randomInt(1, 12)
        }

        @JvmStatic
        fun randomDayOfMonth(month: Int, isLeap: Boolean): Int {
            return randomInt(1, when (month) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                4, 6, 9, 11           -> 30
                2                     -> if (isLeap) 29 else 28
                else -> throw IllegalArgumentException("The month should be 1 to 12: $month")
            })
        }

        @JvmStatic
        fun randomHour24(): Int {
            return Random.Default.nextInt(24)
        }

        @JvmStatic
        fun randomMinuteOrSecond(): Int {
            return Random.Default.nextInt(60)
        }

        private fun checkMinLength(minLength: Int) {
            if (minLength < 0) {
                throw IllegalArgumentException("minLength cannot be negative: $minLength")
            }
        }
    }
}
