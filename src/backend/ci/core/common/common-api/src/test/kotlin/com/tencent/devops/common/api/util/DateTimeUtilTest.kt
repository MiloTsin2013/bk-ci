/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.devops.common.api.util

import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneOffset.MIN
import java.time.format.DateTimeFormatter
import java.util.Date

class DateTimeUtilTest {

    @Test
    fun minuteToSecondTest() {
        val minutes = 60
        println(DateTimeUtil.minuteToSecond(minutes))
        val expected = 3600
        Assert.assertEquals(expected, DateTimeUtil.minuteToSecond(minutes))
    }

    @Test
    fun secondToMinuteTest() {
        val minutes = 3600
        println(DateTimeUtil.secondToMinute(minutes))
        val expected = 60
        Assert.assertEquals(expected, DateTimeUtil.secondToMinute(minutes))
    }

    @Test
    fun formatDateTest() {
        val date = Date.from(LocalDateTime.of(2020, 7, 6, 1, 59, 59).toInstant(MIN))
        val format = "yyyy-MM-dd HH:mm:ss"
        println(DateTimeUtil.formatDate(date, format))
        val expected = "2020-07-07 03:59:59"
        Assert.assertEquals(expected, DateTimeUtil.formatDate(date, format))
    }

    @Test
    fun convertLocalDateTimeToTimestampTest() {
        val date = LocalDateTime.of(2020, 7, 6, 1, 59, 59)
        println(DateTimeUtil.convertLocalDateTimeToTimestamp(date))
        val expected: Long = 1593971999
        Assert.assertEquals(expected, DateTimeUtil.convertLocalDateTimeToTimestamp(date))
    }

    @Test
    fun toDateTimeTest() {
        val date = LocalDateTime.of(2020, 7, 6, 1, 59, 59)
        val format = "yyyy-MM-dd HH:mm:ss"
        println(DateTimeUtil.toDateTime(date, format))
        val expected = "2020-07-06 01:59:59"
        Assert.assertEquals(expected, DateTimeUtil.toDateTime(date, format))
    }

    @Test
    fun zoneDateToTimestampTest() {
        val date = "2019-09-02T08:58:46+0000"
        println(DateTimeUtil.zoneDateToTimestamp(date))
        val expected: Long = 1567414726000
        Assert.assertEquals(expected, DateTimeUtil.zoneDateToTimestamp(date))
    }

    @Test
    fun formatTimeTest() {
        val date = "1567414726000"
        println(DateTimeUtil.formatTime(date))
        val expected = "435392979时26分40秒"
        Assert.assertEquals(expected, DateTimeUtil.formatTime(date))
    }

    @Test
    fun formatMilliTimeTest() {
        val date = "1567414726000"
        println(DateTimeUtil.formatMilliTime(date))
        val expected = "435392时58分46秒"
        Assert.assertEquals(expected, DateTimeUtil.formatMilliTime(date))
    }

    @Test
    fun formatMilliTimeStringTest() {
        val date: Long = 1567414726000
        println(DateTimeUtil.formatMilliTime(date))
        val expected = "435392时58分46秒"
        Assert.assertEquals(expected, DateTimeUtil.formatMilliTime(date))
    }

    @Test
    fun formatMillSecondTest() {
        val date: Long = 1567414726000
        println(DateTimeUtil.formatMillSecond(date))
        val expected = "18141天8时58分46秒"
        Assert.assertEquals(expected, DateTimeUtil.formatMillSecond(date))
    }

    @Test
    fun stringToLocalDateTimeTest() {
        val date = "2020-07-06 01:59:59"
        val format = "yyyy-MM-dd HH:mm:ss"
        println(DateTimeUtil.stringToLocalDateTime(date, format))
        val expected = LocalDateTime.parse("2020-07-06 01:59:59", DateTimeFormatter.ofPattern(format))
        Assert.assertEquals(expected, DateTimeUtil.stringToLocalDateTime(date, format))
    }
}