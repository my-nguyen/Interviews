package ebay

fun main(args: Array<String>) {
    val input = listOf(listOf(4,3,1,7,5,7,2,7,9,7,8,9), listOf(1,1,2,2))
    for (list in input) {
        println("list: ${list}, output: ${solution(list)}")
    }
}

fun solution1(input: List<Int>): Int {
    if (input.isEmpty())
        return 0

    val map = mutableMapOf<Int, Int>()
    for (number in input) {
        map[number] = map.getOrDefault(number, 0) + 1
    }
    var max = 0
    var number = -1
    for ((k, v) in map) {
        if (v > max) {
            max = v
            number = k
        }
    }
    return number
}

fun solution2(input: List<Int>): Int {
    var max = 0
    var number = 0
    for (i in 0..input.lastIndex-1) {
        var count = 1
        for (j in i+1..input.lastIndex) {
            if (input[j] == input[i]) {
                count++
                if (count > max) {
                    max = count
                    number = input[i]
                }
            }
        }
    }
    return number
}

fun solution(input: List<Int>): Int {
    val list = input.sorted()
    var maxCount = 1
    var maxNumber = input.first()
    var number = input.first()
    var count = 1
    for (i in 1..list.lastIndex) {
        if (list[i] == number) {
            count++
            if (count > maxCount) {
                maxCount = count
                maxNumber = list[i]
            }
        } else {
            count = 1
            number = list[i]
        }
    }
    return maxNumber
}