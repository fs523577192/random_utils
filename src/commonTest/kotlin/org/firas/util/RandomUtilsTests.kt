package org.firas.util

import kotlin.test.Test
import kotlin.test.assertTrue

class RandomUtilsTests {
    @Test
    fun testRandomAsciiString() {
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomAsciiString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomAsciiString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            for (c in str) {
                assertTrue(c.toInt() in ' '.toInt() .. '~'.toInt())
            }

            str = RandomUtils.randomAsciiString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            for (c in str) {
                assertTrue(c.toInt() in ' '.toInt() .. '~'.toInt())
            }
        }
    }

    @Test
    fun testRandomUpperCaseAlphabetString() {
        val regExp = Regex("[A-Z]*")
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomUpperCaseAlphabetString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomUpperCaseAlphabetString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomUpperCaseAlphabetString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomLowerCaseAlphabetString() {
        val regExp = Regex("[a-z]*")
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomLowerCaseAlphabetString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomLowerCaseAlphabetString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomLowerCaseAlphabetString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomDigitString() {
        val regExp = Regex("\\d*")
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomDigitString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomDigitString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomDigitString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomAlphanumericString() {
        val regExp = Regex("[A-Z\\d]*", RegexOption.IGNORE_CASE)
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomAlphanumericString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomUpperCaseAlphanumericString() {
        val regExp = Regex("[A-Z\\d]*")
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomUpperCaseAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomUpperCaseAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomUpperCaseAlphanumericString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomLowerCaseAlphanumericString() {
        val regExp = Regex("[a-z\\d]*")
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(0, 1000)
            val b = RandomUtils.randomInt(0, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomLowerCaseAlphanumericString(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomLowerCaseAlphanumericString(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomLowerCaseAlphanumericString(a)
            try {
                assertTrue(str.length in 0..a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }

    @Test
    fun testRandomCIdentifierString() {
        val regExp = Regex("[A-Z_]\\w*", RegexOption.IGNORE_CASE)
        for (j in 0 until 1000) {
            val a = RandomUtils.randomInt(1, 1000)
            val b = RandomUtils.randomInt(1, 1000)
            var str: String
            if (a <= b) {
                str = RandomUtils.randomCIdentifier(a, b)
                try {
                    assertTrue(str.length in a .. b)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            } else {
                str = RandomUtils.randomCIdentifier(b, a)
                try {
                    assertTrue(str.length in b .. a)
                } catch (ex: AssertionError) {
                    println("a is $a and b is $b while str.length is " + str.length)
                    throw ex
                }
            }
            assertTrue(regExp.matches(str))

            str = RandomUtils.randomCIdentifier(a)
            try {
                assertTrue(str.length in 1 .. a)
            } catch (ex: AssertionError) {
                println("a is $a while str.length is " + str.length)
                throw ex
            }
            assertTrue(regExp.matches(str))
        }
    }
}
