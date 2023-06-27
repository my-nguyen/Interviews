package remotasks

import kotlin.math.min

fun main() {
    val matrices = listOf(
        listOf(
            mutableListOf(4,6,14,21),
            mutableListOf(17,0,5,5),
            mutableListOf(4,41,22,3),
            mutableListOf(2,51,6,0)
        ),
        listOf(
            mutableListOf(41,22,56,84),
            mutableListOf(22,51,1,20),
            mutableListOf(5,7,18,19),
            mutableListOf(11,22,3,15)
        )
    )
    for (matrix in matrices) {
        println("max energy: ${maxEnergy(matrix)}")
    }
}

fun maxEnergy(mat: List<MutableList<Int>>): Int {
    // start from the second to last row and iterate backward to the top row
    for (i in 2 downTo 0) {
        for (j in 0..3) {
            // for each cell in the current row, the minimum value is the sum of the cell value and the minimum
            // you can get from the next row based on the current cell position/column
            mat[i][j] = mat[i][j] + minFromRow(mat[i + 1], j)
        }
    }
    return 100 - mat[0].min()
}

// calculate the minimum you can get from the next row based on the current column
private fun minFromRow(row: List<Int>, column: Int): Int {
    // if column is 0, the min is between element 0 and 1 in the next row
    // if column is 1, the min is between element 0, 1, and 2 in the next row
    // if column is 2, the min is between element 1, 2, and 3 in the next row
    // if column is 3, the min is between element 2 and 3 in the next row
    return when (column) {
        0 -> min(row[0], row[1])
        1 -> min(row[0], min(row[1], row[2]))
        2 -> min(row[1], min(row[2], row[3]))
        else -> min(row[2], row[3])
    }
}