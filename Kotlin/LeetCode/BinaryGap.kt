// https://leetcode.com/problems/binary-gap/description
// 868. Binary Gap
// EASY

class Solution {
    fun binaryGap(n: Int): Int {
        var num = n
        while (num > 0 && (num and 1) == 0) {
            num = num shr 1
        }

        var count = 0
        var maxCount = 0
        while (num > 0) {
            if ((num and 1) == 1) {
                if (count > maxCount) {
                    maxCount = count
                }
                count = 0
            }
            num = num shr 1
            count++
        }
        return maxCount
    }
}
