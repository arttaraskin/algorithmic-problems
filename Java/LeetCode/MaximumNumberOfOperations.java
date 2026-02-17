// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
// 3228. Maximum Number of Operations to Move Ones to the End
/* You are given a binary string s.
You can perform the following operation on the string any number of times:
Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
Move the character s[i] to the right until it reaches the end of the string or another '1'. For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
Return the maximum number of operations that you can perform.
Example 1:
Input: s = "1001101"
Output: 4
Explanation:
We can perform the following operations:
Choose index i = 0. The resulting string is s = "0011101".
Choose index i = 4. The resulting string is s = "0011011".
Choose index i = 3. The resulting string is s = "0010111".
Choose index i = 2. The resulting string is s = "0001111". */

class MaximumNumberOfOperations {
    public int maxOperations(String s) {
        int count1 = 0;
        int sum = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            char current = s.charAt(i - 1);
            char next = s.charAt(i);
            if (current == '1') {
                if (next == '0') {
                    count1++;
                }
                sum += count1;
            }
        }
        return sum;
    }
}


public class MaximumNumberOfOperations2 {

    public int maxOperations(String s) {
        int countOne = 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                ans += countOne;
            } else {
                countOne++;
            }
            i++;
        }
        return ans;
    }
}


class MaximumNumberOfOperations3 {
    public int maxOperations(String s) {
        int ones = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                ones++;
            else if (i > 0 && s.charAt(i - 1) == '1')
                res += ones;
        }
        return res;
    }
}
