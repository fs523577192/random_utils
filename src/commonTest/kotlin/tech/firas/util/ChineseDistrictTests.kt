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