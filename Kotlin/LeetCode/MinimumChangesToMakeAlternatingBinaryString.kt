// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description
// 1758. Minimum Changes To Make Alternating Binary String
// EASY

class Solution {
    fun minOperations(s: String): Int {
        val n = s.length
        var count = 0
        for (i in 0 until n step 2) {
            if (s[i] != '0') {
                count++
            }
        }
        for (i in 1 until n step 2) {
            if (s[i] != '1') {
                count++
            }
        }
        return minOf(count, n - count)
    }

    fun minOperations2(s: String): Int {
        val count = s.withIndex().count { (i, c) -> (c - '0') == i % 2 }
        return minOf(count, s.length - count)
    }
}
