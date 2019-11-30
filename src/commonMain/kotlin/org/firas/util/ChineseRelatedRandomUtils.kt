package org.firas.util

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

    /* --== Mobile number ==-- */
    fun randomChineseMobile(): String {
        return "1" + ('0'.toInt() + this.basicUtils.randomInt(3, 9)).toChar() +
                this.randomStringUtils.randomNumericString(9, 9)
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
}