// https://leetcode.com/problems/trionic-array-i/description
// 3637. Trionic Array I

class Solution {
fun isTrionic(nums: IntArray): Boolean {
        if (nums[0] >= nums[1]) {
            return false
        }

        var count = 1
        for (i in 2..<nums.size) {
            if (nums[i - 1] == nums[i]) {
                return false
            }
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++
            }
            if (count > 3) {
                return false
            }
        }
        return count == 3;
    }
	
    fun isTrionic2(nums: IntArray): Boolean {
        if (nums[0] >= nums[1]) {
            return false
        }

        var increasing = true
        var count = 1
        for (i in 1..<nums.size) {
            if (nums[i - 1] == nums[i]) {
                return false
            }
            if (increasing && nums[i - 1] > nums[i]) {
                increasing = false
                count++
            } else if (!increasing && nums[i - 1] < nums[i]) {
                increasing = true
                count++
            }
            if (count > 3) {
                return false
            }
        }
        return count == 3;
    }
}
