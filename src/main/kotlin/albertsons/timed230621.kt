package albertsons

fun main() {
    /*for (n in 1..20) {
        println("n: $n, FizzBuzz: ${FizzBuzz3(n)}")
    }*/
    val list = listOf(2, 5, 10, 4, 3, 9, 3, 5, 7, 2, 6, 4, 8)
    val targets = listOf(7, 9, 17, 18, 20)
    for (target in targets) {
        println("target: $target, pair: ${findIndices(list, target)}")
    }
}

fun FizzBuzz1(n: Int): String {
    return if (n % 3 == 0 && n % 5 == 0)
        "FizzBuzz"
    else if (n % 3 == 0)
        "Fizz"
    else if (n % 5 == 0)
        "Buzz"
    else
        n.toString()
}

fun FizzBuzz2(n: Int): String {
    return when {
        n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n.toString()
    }
}

fun FizzBuzz3(n: Int): String {
    return if (n % 3 == 0) {
        if (n % 5 == 0) "FizzBuzz" else "Fizz"
    } else if (n % 5 == 0)
        "Buzz"
    else
        n.toString()
}

fun findIndices(numbers: List<Int>, target: Int): Pair<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    for ((i, number) in numbers.withIndex()) {
        map[number] = i
        val diff = target - number
        if (diff != number && map.containsKey(diff))
            return Pair(map[number]!!, map[diff]!!)
    }
    return Pair(0, 0)
}