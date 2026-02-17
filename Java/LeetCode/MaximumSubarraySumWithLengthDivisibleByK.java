// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/
// 3381. Maximum Subarray Sum With Length Divisible by K
/* You are given an array of integers nums and an integer k.
Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.

Example 1:
Input: nums = [1,2], k = 1
Output: 3
Explanation:
The subarray [1, 2] with sum 3 has length equal to 2 which is divisible by 1.
Example 2:
Input: nums = [-1,-2,-3,-4,-5], k = 4
Output: -10
Explanation:
The maximum sum subarray is [-1, -2, -3, -4] which has length equal to 4 which is divisible by 4.
Example 3:
Input: nums = [-5,1,2,-3,4], k = 2
Output: 4
Explanation:
The maximum sum subarray is [1, 2, -3, 4] which has length equal to 4 which is divisible by 2. */

public class MaximumSubarraySumWithLengthDivisibleByK {
    public static void main(String[] args) {
        MaximumSubarraySumWithLengthDivisibleByK task = new MaximumSubarraySumWithLengthDivisibleByK();
        System.out.println("Result: " + task.maxSubarraySum(new int[]{1,2}, 1));
        System.out.println("Result: " + task.maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4));
    }

// Using Prefix sum array and Kadane's algorithm
//    Approach:
//    Build a prefix sum array where prefixSum[i] represents the sum of elements from index 0 to i-1.
//    Group subarrays by their starting position modulo k. For each starting position start (0 to k-1), we consider all valid subarrays ending at positions start+k, start+2k, start+3k, etc.
//    For each group, apply Kadane's approach: at each position, compute the sum of the current k-length block and decide whether to extend the previous best subarray or start fresh with just this block.
//    Track the global maximum across all groups.
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        long result = Long.MIN_VALUE;
        for (int start = 0; start < k; start++) {
            long current = 0;
            for (int i = start + k; i <= n; i += k) {
                long sum = prefixSum[i] - prefixSum[i - k];
                current = Math.max(current + sum, sum);
                result = Math.max(result, current);
            }
        }
        return result;
    }

	// 
    public long maxSubarraySum2(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            long sum = 0;
            int start = i;
            for (int j = i + k - 1; j < nums.length; j += k) {
                sum += summarize(nums, start, j + 1);
                if (sum > maxSum) {
                    maxSum = sum;
                }
                start = j + 1;
            }
        }
        return maxSum;
    }
    private long summarize(int[] nums, int from, int to) {
        long sum = 0;
        for (int i = from; i < to; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
