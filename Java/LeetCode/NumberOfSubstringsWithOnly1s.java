// https://leetcode.com/problems/number-of-substrings-with-only-1s/description
// 1513. Number of Substrings With Only 1s
/* Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time. */

class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        final int MODULO = 1000000007;

        long count = 0;
        long sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                if (count > 0) {
                    sum += (1 + count) * count / 2;
                    //sum %= MODULO;
                    count = 0;
                }
            }
        }
        sum += (1 + count) * count / 2;
        sum %= MODULO;
        return (int) sum;
    }
}


class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        final int MODULO = 1000000007;

        long count = 0;
        long sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                sum += ++count; //% MODULO
            } else {
                count = 0;
            }
        }
        sum %= MODULO;
        return (int) sum;
    }
}


class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        final int MODULO = 1000000007;

        long sum = 0;
        String[] arr = s.split("0");
        for (String a : arr) {
            long n = a.length();
            sum += (n * (n + 1))/2;
        }
        sum %= MODULO;
        return (int) sum;
    }
}
