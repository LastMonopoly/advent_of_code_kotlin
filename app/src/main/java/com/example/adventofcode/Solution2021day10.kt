package com.example.adventofcode

fun main() {
    solveSecondHalf(getInput())
}

fun solveSecondHalf(input: List<String>) {
    val scores = mutableListOf<Int>()
    for (line: String in input) {
        if (line.isNotEmpty()) {
            val completions = autoComplete(line)
            if (completions.isNotEmpty()) scores.add(scoreAutoCompletion(completions))
        }
    }
    scores.sort()
    print(scores[scores.count() / 2])
}

fun scoreAutoCompletion(completions: List<Char>): Int {
    val point = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

    var sum = 0
    for (char in completions) {
        sum *= 5
        sum += point[char]!!
    }
    return sum

}

fun autoComplete(line: String): List<Char> {
    val stack = mutableListOf<Char>()

    for (char: Char in line) {
        if (chunk.containsKey(char)) {
            stack.add(char)
        } else if (char == chunk[stack.last()]) {
            stack.removeLast()
        } else {
            return listOf()
        }
    }

    val completion = mutableListOf<Char>()
    while (stack.isNotEmpty()) {
        completion.add(chunk[stack.removeLast()]!!)
    }

    return completion
}

val chunk = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

fun getInput(): List<String> {
    return """
[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]
"""
        .split('\n')
}
