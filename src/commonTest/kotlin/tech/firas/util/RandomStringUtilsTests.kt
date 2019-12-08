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
import kotlin.test.assertTrue

class RandomStringUtilsTests {
    @Test
    fun testRandomAsciiString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomAsciiString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomAsciiString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            for (c in str) {
                assertTrue(c.toInt() in ' '.toInt() .. '~'.toInt() ||
                        '\t' == c || '\n' == c || '\r' == c)
            }
        }
    }

    @Test
    fun testRandomUpperCaseAlphabetString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[A-Z]*")
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomUpperCaseAlphabeticString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomUpperCaseAlphabeticString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomLowerCaseAlphabetString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[a-z]*")
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomLowerCaseAlphabeticString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomLowerCaseAlphabeticString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomDigitString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("\\d*")
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomNumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomNumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomAlphanumericString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[A-Z\\d]*", RegexOption.IGNORE_CASE)
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomUpperCaseAlphanumericString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[A-Z\\d]*")
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomUpperCaseAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomUpperCaseAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomLowerCaseAlphanumericString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[a-z\\d]*")
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(0, 1000)
            val b = basicRandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomLowerCaseAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomLowerCaseAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomCIdentifierString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        val regExp = Regex("[A-Z_]\\w*", RegexOption.IGNORE_CASE)
        for (j in 0 until 1000) {
            val a = basicRandomUtils.randomInt(1, 1000)
            val b = basicRandomUtils.randomInt(1, 1000)
            var str: String
            if (a <= b) {
                str = randomStringUtils.randomCIdentifier(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = randomStringUtils.randomCIdentifier(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testChineseString() {
        val basicRandomUtils = BasicRandomUtils.getDefault()
        val randomStringUtils = RandomStringUtils.getDefault()
        for (j in 0 until 20) {
            val a = basicRandomUtils.randomInt(1, 80)
            val b = basicRandomUtils.randomInt(a, 80)
            println(randomStringUtils.randomCommonChineseString(a, b))
            println(randomStringUtils.randomBasicChineseString(a, b))
        }
    }
}
