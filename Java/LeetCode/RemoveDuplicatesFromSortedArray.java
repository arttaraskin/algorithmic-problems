// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// 26. Remove Duplicates from Sorted Array
/* Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored. */

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}
