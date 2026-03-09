// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description
// 1784. Check if Binary String Has at Most One Segment of Ones
// EASY
/* Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.

Example 1:
Input: s = "1001"
Output: false
Explanation: The string has two segments of size 1.
Example 2:
Input: s = "110"
Output: true */

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        int start = 1;
        while (start < s.length() && s.charAt(start) == '1') {
            start++;
        }
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }
}
