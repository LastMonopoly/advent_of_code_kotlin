// Copyright 2022 LastMonopoly@outlook.com. All rights reserved.
// Solution to https://adventofcode.com/2018/day/10

package com.example.adventofcode

fun main() {
    solve(getInput())
}

fun solve(input: List<String>) {
    val p = Point.parse("position=<-40143,  50606> velocity=< 4, -5>")
    println(p)
}


class Point(val x: Int, val y: Int, val dx: Int, val dy: Int) {
    companion object {
        fun parse(line: String): Point {
            var l: Int = line.indexOf('<')
            var r: Int = line.indexOf(',')
            val x = line.substring(l + 1, r).trim().toInt()
            l = line.indexOf(',')
            r = line.indexOf('>')
            val y = line.substring(l + 1, r).trim().toInt()
            l = line.lastIndexOf('<')
            r = line.lastIndexOf(',')
            val dx = line.substring(l + 1, r).trim().toInt()
            l = line.lastIndexOf(',')
            r = line.lastIndexOf('>')
            val dy = line.substring(l + 1, r).trim().toInt()

            return Point(x, y, dx, dy)
        }
    }

    override fun toString(): String {
        return "[$x, $y] +[$dx, $dy])"
    }

    override fun equals(other: Any?): Boolean {
        return other is Point && x == other.x && y == other.y
    }

    override fun hashCode(): Int {
        return x * x + y * y
    }
}

private fun getInput(test: Boolean = true): List<String> {
    return """
position=< 9,  1> velocity=< 0,  2>
position=< 7,  0> velocity=<-1,  0>
position=< 3, -2> velocity=<-1,  1>
position=< 6, 10> velocity=<-2, -1>
position=< 2, -4> velocity=< 2,  2>
position=<-6, 10> velocity=< 2, -2>
position=< 1,  8> velocity=< 1, -1>
position=< 1,  7> velocity=< 1,  0>
position=<-3, 11> velocity=< 1, -2>
position=< 7,  6> velocity=<-1, -1>
position=<-2,  3> velocity=< 1,  0>
position=<-4,  3> velocity=< 2,  0>
position=<10, -3> velocity=<-1,  1>
position=< 5, 11> velocity=< 1, -2>
position=< 4,  7> velocity=< 0, -1>
position=< 8, -2> velocity=< 0,  1>
position=<15,  0> velocity=<-2,  0>
position=< 1,  6> velocity=< 1,  0>
position=< 8,  9> velocity=< 0, -1>
position=< 3,  3> velocity=<-1,  1>
position=< 0,  5> velocity=< 0, -1>
position=<-2,  2> velocity=< 2,  0>
position=< 5, -2> velocity=< 1,  2>
position=< 1,  4> velocity=< 2,  1>
position=<-2,  7> velocity=< 2, -2>
position=< 3,  6> velocity=<-1, -1>
position=< 5,  0> velocity=< 1,  0>
position=<-6,  0> velocity=< 2,  0>
position=< 5,  9> velocity=< 1, -2>
position=<14,  7> velocity=<-2,  0>
position=<-3,  6> velocity=< 2, -1>
""".trim().split("\n")
}
