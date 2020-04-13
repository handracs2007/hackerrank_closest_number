import kotlin.math.abs

//https://www.hackerrank.com/challenges/closest-numbers/problem

fun closestNumbers(arr: Array<Int>): Array<Int> {
    val pairMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    // Sort the input
    arr.sort()

    // Do the calculation
    for (i in 1 until arr.size) {
        val diff = abs(arr[i] - arr[i - 1])

        if (!pairMap.containsKey(diff)) {
            pairMap[diff] = mutableListOf()
        }

        pairMap[diff]!!.add(Pair(arr[i - 1], arr[i]))
    }

    val minDiff = pairMap.keys.min()!!
    return pairMap[minDiff]!!.flatMap { listOf(it.first, it.second) }.toTypedArray()
}

fun main() {
    println(
        closestNumbers(
            "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470".split(" ")
                .map { it.toInt() }.toTypedArray()
        ).toList()
    )

    println(
        closestNumbers(
            "5 4 3 2".split(" ")
                .map { it.toInt() }.toTypedArray()
        ).toList()
    )
}