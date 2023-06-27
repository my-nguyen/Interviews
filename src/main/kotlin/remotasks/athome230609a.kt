package remotasks

import kotlin.math.min

fun main() {
    val listA = listOf(listOf(1,1,4,5,5), listOf(1,2,3))
    val listB = listOf(listOf(4,4,3,1,5), listOf(4,5,6))
    val k = listOf(2, 5)
    for (i in k.indices) {
        println("a: ${listA[i]}, b: ${listB[i]}, k: ${k[i]} => maximum distinct count: ${getMaximumDistinctCount(listA[i], listB[i], k[i])}")
    }
}

fun getMaximumDistinctCount(a: List<Int>, b: List<Int>, k: Int): Int {
    // count frequency of all entries in list a
    val map = mutableMapOf<Int, Int>()
    for (n in a) {
        map[n] = map.getOrDefault(n, 0) + 1
    }
    // size represents the number of distinct integers in a
    val size = map.size // 1,1,4,5,5 => size = 3

    // collect all entries in b that don't exist in a
    val set = mutableSetOf<Int>()
    for (n in b) {
        if (!map.containsKey(n)) set.add(n)
    }
    // if all elements in b appear in a, then return the number of distinct integers in a
    if (set.size == 0) // a=1,1,4,5,5; b=4,4,3,1,5 => set.size = 1
        return size

    // remove from map all entries with frequency of 1
    map.entries.removeIf { it.value == 1 }

    // if map doesn't contain any entry with frequency greater than 1, then all numbers are distinct
    // otherwise return the number of distinct integers plus the minimum between k and the number of integers with
    // frequency greater than 1
    return if (map.isEmpty()) a.size else size + min(k, set.size)
}
