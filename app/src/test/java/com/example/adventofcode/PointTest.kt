package com.example.adventofcode

import org.junit.Assert.*

import org.junit.Test

class PointTest {
    @Test
    fun parse_smallNumber() {
        val p = Point.parse("position=< 6, 10> velocity=<-2, -1>")
        assertEquals(p.x, 6)
        assertEquals(p.y, 10)
        assertEquals(p.dx, -2)
        assertEquals(p.dy, -1)
    }

    @Test
    fun parse_bigNumber() {
        val p = Point.parse("position=<-40143,  50606> velocity=< 4, -5>")
        assertEquals(p.x, -40143)
        assertEquals(p.y, 50606)
        assertEquals(p.dx, 4)
        assertEquals(p.dy, -5)
    }

    @Test
    fun testEquals() {
        val p1 = Point(1, 2, 3, 4)
        val p2 = Point(1, 2, 5, 6)
        val p3 = Point(3, 4, 5, 6)
        assertEquals(p1, p2)
        assertNotEquals(p1, p3)
        assertNotEquals(p2, p3)
    }
}