// http://leetcode.com/problems/merge-sorted-array/
// 88. Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m // elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];

        int i1 = 0, i2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (i2 >= n) {
                merge[i] = nums1[i1];
                i1++;
            } else if (i1 < m && nums1[i1] <= nums2[i2]) {
                merge[i] = nums1[i1];
                i1++;
            } else {
                merge[i] = nums2[i2];
                i2++;
            }
        }

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }
}
