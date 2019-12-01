package tech.firas.util

import kotlin.jvm.JvmStatic
import kotlin.random.Random

class BasicRandomUtils(private val random: Random) {

    companion object {

        private val singleton = BasicRandomUtils(Random.Default)

        private val specialCharInFrench = charArrayOf(
                'à', 'â', 'è', 'é', 'ê', 'î', 'ï', 'ô', 'ö', 'ù', 'û', 'ü', 'ç', 'œ', 'æ',
                'À', 'Â', 'È', 'É', 'Ê', 'Ë', 'Î', 'Ï', 'Ô', 'Ö', 'Ù', 'Û', 'Ç', 'Œ', 'Æ'
        )

        @JvmStatic
        fun getDefault(): BasicRandomUtils {
            return singleton
        }

        internal fun checkMinLength(minLength: Int) {
            if (minLength < 0) {
                throw IllegalArgumentException("minLength cannot be negative: $minLength")
            }
        }
    }

    fun randomBoolean(): Boolean {
        return this.random.nextBoolean()
    }

    fun randomNullableBoolean(): Boolean? {
        return when (this.random.nextInt(3)) {
            0 -> false
            1 -> true
            else -> null
        }
    }

    /**
     * @param min lower bound (inclusive)
     * @param max upper bound (inclusive)
     */
    fun randomInt(min: Int, max: Int): Int {
        return this.random.nextInt(min, max + 1)
    }

    fun randomAsciiChar(): Char {
        val n = randomInt(' '.toInt() - 3, '~'.toInt())
        return when (n) {
            ' '.toInt() - 3 -> '\t' // \u0009
            ' '.toInt() - 2 -> '\n' // \u000A
            ' '.toInt() - 1 -> '\r' // \u000D
            else -> n.toChar()
        }
    }

    fun randomUpperCaseAlphabet(): Char {
        return randomInt('A'.toInt(), 'Z'.toInt()).toChar()
    }

    fun randomLowerCaseAlphabet(): Char {
        return randomInt('a'.toInt(), 'z'.toInt()).toChar()
    }

    fun randomAlphabet(): Char {
        return if (this.random.nextBoolean()) randomUpperCaseAlphabet() else randomLowerCaseAlphabet()
    }

    fun randomDigit(): Char {
        return randomInt('0'.toInt(), '9'.toInt()).toChar()
    }

    fun randomUpperCaseAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26)
        return if (n < 10) ('0'.toInt() + n).toChar()
        else ('A'.toInt() + n - 10).toChar()
    }

    fun randomLowerCaseAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26)
        return if (n < 10) ('0'.toInt() + n).toChar()
        else ('a'.toInt() + n - 10).toChar()
    }

    fun randomAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26 * 2)
        return when {
            n < 10        -> ('0'.toInt() + n).toChar()
            n < (10 + 26) -> ('A'.toInt() + n - 10).toChar()
            else          -> ('a'.toInt() + n - 10 - 26).toChar()
        }
    }

    /**
     * @return a Chinese character in Unicode range 4E00-9FE6
     */
    fun randomCommonChineseChar(): Char {
        return this.randomInt(0x4E00, 0x9FE6).toChar()
    }

    fun randomChineseChar(): Char {
        TODO()
    }

    /**
     * @return a random alphabet that may exist in a French word
     */
    fun randomFrenchAlphabet(): Char {
        val n = this.random.nextInt(26 * 2 + specialCharInFrench.size)
        return when {
            n < 26     -> ('A'.toInt() + n).toChar()
            n < 26 * 2 -> ('a'.toInt() + n - 26).toChar()
            else       -> specialCharInFrench[n - 26 * 2]
        }
    }

    fun randomFrenchAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26 * 2 + specialCharInFrench.size)
        return when {
            n < 10            -> ('0'.toInt() + n).toChar()
            n < (10 + 26)     -> ('A'.toInt() + n - 10).toChar()
            n < (10 + 26 * 2) -> ('a'.toInt() + n - 10 - 26).toChar()
            else              -> specialCharInFrench[n - 10 - 26 * 2]
        }
    }

    fun randomAsciiAndFrenchChar(): Char {
        val n = randomInt(' '.toInt() - 3, '~'.toInt() + specialCharInFrench.size)
        return when {
            (' '.toInt() - 3) == n  -> '\t' // \u0009
            (' '.toInt() - 2) == n  -> '\n' // \u000A
            (' '.toInt() - 1) == n  -> '\r' // \u000D
            n > '~'.toInt()         -> specialCharInFrench[n - '~'.toInt()]
            else -> n.toChar()
        }
    }
}
