// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description
// 1758. Minimum Changes To Make Alternating Binary String
// EASY
/* You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
Return the minimum number of operations needed to make s alternating.

Example 1:
Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:
Input: s = "10"
Output: 0
Explanation: s is already alternating.
Example 3:
Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010". */

class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != '0') {
                count++;
            }
        }
        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != '1') {
                count++;
            }
        }
        return Math.min(count, n - count);
    }
	
	public int minOperations2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) - '0' == i % 2) {
                count++;
            }
        }
        return Math.min(count, s.length() - count);
    }
}
