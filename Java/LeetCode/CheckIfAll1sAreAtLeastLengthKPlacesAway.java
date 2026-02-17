// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description
// 1437. Check If All 1's Are at Least Length K Places Away
/* Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other. */

class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int start = 0;
        while (start < nums.length && nums[start] == 0) {
            start++;
        }

        int count = 0;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count < k) {
                    return false;
                }
                count = 0;
            }
        }
        return true;
    }
}


class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int last = - (k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - last - 1 < k) {
                    return false;
                }
                last = i;
            }
        }
        return true;
    }
}
