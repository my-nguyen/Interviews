package remotasks

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val lists = listOf(mutableListOf(4, 7, 1, 4), mutableListOf(4, 7, 7))
    for (list in lists) {
        println("list $list => minimum cost: ${getMinimumCost(list)}")
    }
}

fun getMinimumCost(list: MutableList<Int>): Long {
    var i = 1
    var gap = abs(list[1] - list[0])
    // find the maximum gap between 2 consecutive elements in the list
    for (j in 2..list.lastIndex) {
        val diff = abs(list[j] - list[j-1])
        if (diff > gap) {
            gap = diff
            i = j
        }
    }

    // there's no gap
    if (gap == 0) return 0L

    val half = gap / 2
    val sum = getSum(list, i, half)
    return if (gap % 2 == 0) {
        // if the gap is even, return the sum calculated
        sum
    } else {
        // if the gap is odd, return the min of 2 sums: one at half way and one at 1 past halfway
        min(sum, getSum(list, i, half + 1))
    }
}

// find the sum of the squared differences after inserting a value halfway in between the gap
private fun getSum(list: MutableList<Int>, i: Int, half: Int): Long {
    // calculate the value halfway in between the gap
    val value = min(list[i], list[i-1]) + half
    // temporarily insert the value into the gap
    list.add(i, value)
    // now calculate the sum of all the squared differences
    var sum = 0L
    for (j in 1..list.lastIndex) {
        val diff = list[j] - list[j-1]
        sum += diff * diff
    }
    // restore the list
    list.removeAt(i)

    return sum
}