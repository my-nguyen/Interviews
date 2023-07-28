package wellsfargo

fun main() {
    val strings = listOf("Hi, I'm John!")
    for (string in strings) {
        println("string $string")
        println("encode: ${string.ncode()}")
    }
}

fun String.ncode(): String {
    val chars = CharArray(length)
    for ((i, c) in withIndex()) {
        chars[i] = if (!c.isLetter())
            c
        else if (c.isLowerCase())
            'a' + (c - 'a' + 1) % 26
        else
            'A' + (c - 'A' + 1) % 26
    }
    val intermediate = String(chars)
    println("intermediate $intermediate")

    val builder = StringBuilder()
    for (word in intermediate.split(" ")) {
        var i = 0
        var j = if (word.last().isLetter()) word.lastIndex else word.lastIndex - 1
        val tmp = word.toCharArray()
        while (i < j) {
            swap(tmp, i, j)
            i++
            j--
        }
        builder.append(tmp).append(" ")
    }
    return builder.toString()
}

private fun swap(chars: CharArray, i: Int, j: Int) {
    val isLowerCaseI = chars[i].isLowerCase()
    val isLowerCaseJ = chars[j].isLowerCase()
    val c = chars[i]
    chars[i] = if (isLowerCaseI) chars[j].lowercaseChar() else chars[j].uppercaseChar()
    chars[j] = if (isLowerCaseJ) c.lowercaseChar() else c.uppercaseChar()
}