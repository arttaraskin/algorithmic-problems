// https://leetcode.com/problems/transformed-array/description
// 3379. Transformed Array

class TransformedArray {
    fun constructTransformedArray(nums: IntArray): IntArray {
        val n = nums.size
        var result = IntArray(n)
        for (i in 0..<n) {
            result[i] = nums[((i + nums[i]) % n + n) % n]
        }
        return result
    }
}
