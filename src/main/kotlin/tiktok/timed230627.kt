package tiktok

fun main() {
    val counts = listOf(0, 1, 2, 3)
    for (count in counts) {
        println(generateParentheses(count))
    }
}

private fun generateParentheses(n: Int): List<String> {
    if (n == 0) return listOf()

    val result = mutableListOf<String>()
    generate(n, 0, 0, "", result)
    return result
}

private fun generate(n: Int, l: Int, r: Int, s: String, result: MutableList<String>) {
    if (l == n && r == n) {
        result.add(s)
        return
    }

    if (l < n)
        generate(n, l+1, r, "$s(", result)
    if (r < l)
        generate(n, l, r+1, "$s)", result)
}