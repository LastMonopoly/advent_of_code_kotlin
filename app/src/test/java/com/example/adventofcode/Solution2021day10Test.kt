package com.example.adventofcode

import org.junit.Assert.*

import org.junit.Test

class Solution2021day10Test {
    @Test
    fun autoComplete() {
        assertEquals(
            autoComplete("[({(<(())[]>[[{[]{<()<>>").joinToString(separator = ""),
            "}}]])})]"
        )
        assertEquals(
            autoComplete("[(()[<>])]({[<{<<[]>>(").joinToString(separator = ""),
            ")}>]})"
        )
        assertEquals(
            autoComplete("(((({<>}<{<{<>}{[]{[]{}").joinToString(separator = ""),
            "}}>}>))))"
        )
        assertEquals(
            autoComplete("{<[[]]>}<{[{[{[]{()[[[]").joinToString(separator = ""),
            "]]}}]}]}>"
        )
        assertEquals(
            autoComplete("<{([{{}}[<[[[<>{}]]]>[]]").joinToString(separator = ""),
            "])}>"
        )
    }

    @Test
    fun getIllegalChar_allLegal() {
        assertEquals(getIllegalChar("([])"), ' ')
        assertEquals(getIllegalChar("{()()()}"), ' ')
        assertEquals(getIllegalChar("<([{}])>"), ' ')
        assertEquals(getIllegalChar("[<>({}){}[([])<>]]"), ' ')
        assertEquals(getIllegalChar("(((((((((())))))))))"), ' ')
    }

    @Test
    fun getIllegalChar_allIllegal() {
        assertEquals(getIllegalChar("{([(<{}[<>[]}>{[]{[(<()>"), '}')
        assertEquals(getIllegalChar("[[<[([]))<([[{}[[()]]]"), ')')
        assertEquals(getIllegalChar("[{[{({}]{}}([{[{{{}}([]"), ']')
        assertEquals(getIllegalChar("[<(<(<(<{}))><([]([]()"), ')')
        assertEquals(getIllegalChar("<{([([[(<>()){}]>(<<{{"), '>')
    }
}