// https://leetcode.com/problems/minimum-removals-to-balance-array/description
// 3634. Minimum Removals to Balance Array

class MinimumRemovalsToBalanceArray {
    fun minRemoval(nums: IntArray, k: Int): Int {
        val n = nums.size
        if (n <= 1) {
            return 0
        }

        nums.sort()

        var ans = n
        var right = 0
        for (left in 0 until n) {
            while (right < n && nums[right].toLong() <= nums[left].toLong() * k) {
                right++
            }
            ans = min(ans, n - (right - left))
        }

        return ans        
    }
}
