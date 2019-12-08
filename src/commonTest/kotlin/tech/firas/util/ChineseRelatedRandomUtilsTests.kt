/*
 * Copyright $today.year-2019 the original author or authors.
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

class ChineseRelatedRandomUtilsTests {
    @Test
    fun testRandomChineseMobileStrict() {
        val regExp = Regex("1(3\\d|4[5-9]|5[0-35-9]|6[56]|7[2-8]|8\\d|9[1389])\\d{8}")
        val utils = ChineseRelatedRandomUtils.getDefault()
        for (i in 0 until 1000) {
            val str = utils.randomChineseMobileStrict()
            val result = regExp.matches(str)
            if (!result) {
                kotlin.test.fail("$str is not a Chinese mobile phone number")
            }
        }
    }
}
