// https://leetcode.com/problems/trionic-array-i/description
// 3637. Trionic Array I

/* You are given an integer array nums of length n.
An array is trionic if there exist indices 0 < p < q < n − 1 such that:
nums[0...p] is strictly increasing,
nums[p...q] is strictly decreasing,
nums[q...n − 1] is strictly increasing.
Return true if nums is trionic, otherwise return false.

Example 1:
Input: nums = [1,3,5,4,2,6]
Output: true
Explanation:
Pick p = 2, q = 4:
nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
nums[4...5] = [2, 6] is strictly increasing (2 < 6).
Example 2:
Input: nums = [2,1,3]
Output: false
Explanation:
There is no way to pick p and q to form the required three segments. */

class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) {
            return false;
        }

        int count = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;
            }
            if (count > 3) {
                return false;
            }
        }
        return count == 3;        
    }
	
	public boolean isTrionic2(int[] nums) {
        if (nums[0] >= nums[1]) {
            return false;
        }

        var increasing = true;
        var count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if (increasing && nums[i - 1] > nums[i]) {
                increasing = false;
                count++;
            } else if (!increasing && nums[i - 1] < nums[i]) {
                increasing = true;
                count++;
            }
            if (count > 3) {
                return false;
            }
        }
        return count == 3;
    }
}
