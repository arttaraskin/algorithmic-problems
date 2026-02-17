// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
// 34. Find First and Last Position of Element in Sorted Array
/* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1] */

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        // Binary search
        int left = 0;
        int right = nums.length - 1;
        int midIndex = 0;
        boolean found = false;
        while (left <= right) {
            midIndex = left + (right - left) / 2;
            if (nums[midIndex] == target) {
                found = true;
                break;
            } else if (nums[midIndex] < target) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        // Find all duplicate values
        if (found) {
            left = midIndex;
            while (left - 1 >= 0 && nums[left - 1] == target) {
                left--;
            }
            right = midIndex;
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            return new int[]{left, right};
        }
        // target is not found
        return new int[]{-1, -1};
    }
	
	
	// Search left and right separately
	public int[] searchRange2(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};        
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return idx;
    }
}
