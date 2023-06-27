package TikTok

fun main() {
    val counts = listOf(0, 1, 2, 3)
    for (count in counts) {
        println(generateParentheses(count))
    }
}

private fun generateParentheses(count: Int): List<String> {
    val result = mutableListOf<String>()
    generate(count, 0, 0, "", result)
    return result
}

private fun generate(count: Int, left: Int, right: Int, string: String, result: MutableList<String>) {
    if (left == count && right == count) {
        result.add(string)
        return
    }

    if (left < count)
        generate(count, left+1, right, "$string(", result)
    if (right < left)
        generate(count, left, right+1, "$string)", result)
}