// https://leetcode.com/problems/count-binary-substrings/description
// 696. Count Binary Substrings
// EASY/MIDDLE

class CountBinarySubstrings {
    fun countBinarySubstrings(s: String): Int {
        var consecutiveCount = 1
        var prevConsecutiveCount = 0
        var ans = 0
        for (i in 1 until s.length) {
            if (s[i] != s[i - 1]) {
                prevConsecutiveCount = consecutiveCount
                consecutiveCount = 1
                ans++
            } else {
                consecutiveCount++
                if (consecutiveCount <= prevConsecutiveCount) ans++
            }
        }
        return ans
    }
}
