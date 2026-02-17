// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/?envType=daily-question&envId=2026-01-25
// 1984. Minimum Difference Between Highest and Lowest of K Scores

class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        var minDiff = Int.MAX_VALUE
        for (i in 0..< nums.size - k + 1) {
            val diff = nums[i + k - 1] - nums[i]
            if (diff < minDiff) minDiff = diff
        }
        return minDiff        
    }
}
