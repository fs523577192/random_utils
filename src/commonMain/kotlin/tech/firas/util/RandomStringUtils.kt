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

import tech.firas.util.BasicRandomUtils.Companion.checkMinLength

/**
 *
 * @author Wu Yuping
 */
class RandomStringUtils(private val random: Random) {

    companion object {

        private val singleton = RandomStringUtils(Random.Default)

        @JvmStatic
        fun getDefault(): RandomStringUtils {
            return singleton
        }
    }

    private val basicUtils = if (Random.Default == this.random) BasicRandomUtils.getDefault()
                            else BasicRandomUtils(this.random)

    fun randomAsciiString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomAsciiChar())
        }
        return builder.toString()
    }

    fun randomUpperCaseAlphabeticString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomUpperCaseAlphabet())
        }
        return builder.toString()
    }

    fun randomLowerCaseAlphabeticString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomLowerCaseAlphabet())
        }
        return builder.toString()
    }

    fun randomAlphabeticString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomAlphabet())
        }
        return builder.toString()
    }

    fun randomNumericString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomDigit())
        }
        return builder.toString()
    }

    fun randomUpperCaseAlphanumericString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomUpperCaseAlphanumeric())
        }
        return builder.toString()
    }

    fun randomLowerCaseAlphanumericString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomLowerCaseAlphanumeric())
        }
        return builder.toString()
    }

    fun randomAlphanumericString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomAlphanumeric())
        }
        return builder.toString()
    }

    fun randomCommonChineseString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomCommonChineseChar())
        }
        return builder.toString()
    }

    fun randomBasicChineseString(minLength: Int, maxLength: Int): String {
        checkMinLength(minLength)
        val length = this.basicUtils.randomInt(minLength, maxLength)
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(this.basicUtils.randomBasicChineseChar())
        }
        return builder.toString()
    }

    /**
     * A C / C++ / Java identifier contains only alphanumeric characters and underscore('_')
     * and does NOT start with a digit
     * @param minLength the minimum length of the generated String,
     *                   cannot be less than 1 as a C identifier cannot be an empty string
     * @param maxLength the maximum length of the generated String
     * @return a C / C++ / Java idendifier that is randomly generated
     */
    fun randomCIdentifier(minLength: Int, maxLength: Int): String {
        if (minLength < 1) {
            throw IllegalArgumentException("minLength should be positive: $minLength")
        }
        val builder = StringBuilder()
        var n = this.basicUtils.randomInt(0, 26 * 2)
        builder.append(when {
            n < 26     -> ('A'.toInt() + n).toChar()
            n < 26 * 2 -> ('a'.toInt() + n - 26).toChar()
            else -> '_'
        })

        val length = this.basicUtils.randomInt(minLength - 1, maxLength - 1)
        for (i in 0 until length) {
            n = this.basicUtils.randomInt(0, 26 * 2 + 10)
            builder.append(when {
                n < 10            -> ('0'.toInt() + n).toChar()
                n < (26 + 10)     -> ('A'.toInt() + n - 10).toChar()
                n < (26 * 2 + 10) -> ('a'.toInt() + n - (26 + 10)).toChar()
                else              -> '_'
            })
        }
        return builder.toString()
    }
}