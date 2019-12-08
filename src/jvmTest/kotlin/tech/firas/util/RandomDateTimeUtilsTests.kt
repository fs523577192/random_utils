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

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 *
 * @author Wu Yuping
 */
class RandomDateTimeUtilsTests {
    @Test
    fun test() {
        val randomDateTimeUtils = RandomDateTimeUtils.getDefault()
        val formatter = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        for (i in 1..1000) {
            val year = BasicRandomUtils.getDefault().randomInt(1910, 2019)
            val month = RandomDateTimeUtils.getDefault().randomMonth()
            val str = "$year-" + ensureTwoDigits(month) + '-' +
                    ensureTwoDigits(randomDateTimeUtils.randomDayOfMonth(month, year)) +
                    ' ' + ensureTwoDigits(randomDateTimeUtils.randomHour24()) +
                    ':' + ensureTwoDigits(randomDateTimeUtils.randomMinuteOrSecond()) +
                    ':' + ensureTwoDigits(randomDateTimeUtils.randomMinuteOrSecond())
            println(str)
            assertEquals( str, formatter.format(formatter.parse(str)) )
        }
    }

    private fun ensureTwoDigits(n: Int): String {
        return if (n >= 10) n.toString() else ("0" + n)
    }
}