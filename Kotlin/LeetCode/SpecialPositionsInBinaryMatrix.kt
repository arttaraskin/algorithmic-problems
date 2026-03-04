// https://leetcode.com/problems/special-positions-in-a-binary-matrix/description
// 1582. Special Positions in a Binary Matrix
// EASY

class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rowCount = IntArray(m)
        val colCount = IntArray(n)
        for (row in 0 until m) {
            for (col in 0 until n) {
                if (mat[row][col] == 1) {
                    rowCount[row]++
                    colCount[col]++
                }
            }
        }

        var count = 0
        for (row in 0 until m) {
            if (rowCount[row] == 1) {
                for (col in 0 until n) {
                    if (colCount[col] == 1 && mat[row][col] == 1) {
                        count++
                        break
                    }
                }
            }
        }
        return count
    }
}
