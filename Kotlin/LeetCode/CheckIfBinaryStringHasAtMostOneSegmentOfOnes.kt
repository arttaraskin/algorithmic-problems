// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description
// 1784. Check if Binary String Has at Most One Segment of Ones
// EASY

class Solution {
    fun checkOnesSegment(s: String): Boolean {
        var start = 1
        while (start < s.length && s[start] == '1') {
            start++
        }
        for (i in start + 1 until s.length) {
            if (s[i] == '1') {
                return false
            }
        }
        return true
    }
}
