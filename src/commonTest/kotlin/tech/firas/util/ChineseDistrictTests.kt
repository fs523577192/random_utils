package tech.firas.util

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 *
 * @author Wu Yuping
 */
class ChineseDistrictTests {
    @Test
    fun testLevel() {
        assertTrue(ChineseDistrict._110000.isProvinceLevel()) // 北京
        assertFalse(ChineseDistrict._110000.isPrefectureLevel())
        assertFalse(ChineseDistrict._110000.isLowestLevel())
        assertFalse(ChineseDistrict._110105.isProvinceLevel()) // 北京朝阳区
        assertTrue(ChineseDistrict._110105.isPrefectureLevel())
        assertTrue(ChineseDistrict._110105.isLowestLevel())

        assertTrue(ChineseDistrict._440000.isProvinceLevel()) // 广东
        assertFalse(ChineseDistrict._440000.isPrefectureLevel())
        assertFalse(ChineseDistrict._440000.isLowestLevel())
        assertFalse(ChineseDistrict._440100.isProvinceLevel()) // 广州
        assertTrue(ChineseDistrict._440100.isPrefectureLevel())
        assertFalse(ChineseDistrict._440100.isLowestLevel())
        assertFalse(ChineseDistrict._440106.isProvinceLevel()) // 天河
        assertFalse(ChineseDistrict._440106.isPrefectureLevel())
        assertTrue(ChineseDistrict._440106.isLowestLevel())
    }

    @Test
    fun testName() {
        assertEquals("北京市", ChineseDistrict._110000.getNameWithCity())
        assertEquals("北京市", ChineseDistrict._110000.getNameWithProvince())
        assertEquals("北京市朝阳区", ChineseDistrict._110105.getNameWithCity())
        assertEquals("北京市朝阳区", ChineseDistrict._110105.getNameWithProvince())

        assertEquals("广东省", ChineseDistrict._440000.getNameWithProvince())
        assertEquals("广州市", ChineseDistrict._440100.getNameWithCity())
        assertEquals("广东省广州市", ChineseDistrict._440100.getNameWithProvince())
        assertEquals("广东省广州市天河区", ChineseDistrict._440106.getNameWithProvince())
        assertEquals("广州市天河区", ChineseDistrict._440106.getNameWithCity())
    }
}