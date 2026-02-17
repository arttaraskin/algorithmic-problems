// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description
// 961. N-Repeated Element in Size 2N Array
/* You are given an integer array nums with the following properties:
nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.

Example 1:
Input: nums = [1,2,3,3]
Output: 3
Example 2:
Input: nums = [2,1,2,5,3,2]
Output: 2
Example 3:
Input: nums = [5,1,5,2,5,3,5,4]
Output: 5 */

class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
	
	public int repeatedNTimes2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        // only 2 cases left: separated by exactly one place ("XaXbXc"), and size 4 in edges ("XabX")
        return (nums[0] == nums[2]) ? nums[0] : nums[3];
    }
}
