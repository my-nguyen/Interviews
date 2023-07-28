package wellsfargo

fun main() {
    val strings = listOf("Hi, I'm John!")
    for (string in strings) {
        println("string $string")
        println("encode: ${string.ncode()}")
    }
}

fun String.encode(): String {
    val array = CharArray(length)
    for ((i, c) in withIndex()) {
        if (!c.isLetter())
            array[i] = c
        else if (c.isLowerCase())
            array[i] = 'a' + (c - 'a' + 1) % 26
        else
            array[i] = 'A' + (c - 'A' + 1) % 26
    }
    val intermediate = array.joinToString("")
    println("intermediate $intermediate")

    val words = intermediate.split(" ")
    val builder = StringBuilder()
    for (word in words) {
        var i = 0
        var j = word.lastIndex
        if (!word[j].isLetter())
            j--
        val tmp = word.toCharArray()
        while (i < j) {
            val c = tmp[i]
            tmp[i] = tmp[j]
            tmp[j] = c
            i++
            j--
        }
        builder.append(tmp).append(" ")
    }
    return builder.toString()
}