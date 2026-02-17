// https://leetcode.com/problems/minimum-absolute-difference/description
// 1200. Minimum Absolute Difference

class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        var result = mutableListOf<List<Int>>()
        var minDiff = Int.MAX_VALUE
        for (i in 1..<arr.size) {
            val diff = arr[i] - arr[i - 1]
            if (diff < minDiff) {
                minDiff = diff
                result = mutableListOf()
            }
            if (diff == minDiff) {
                result.add(listOf(arr[i - 1], arr[i]))
            }
        }
        return result
    }
}
