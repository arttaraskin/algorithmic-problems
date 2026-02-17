// https://leetcode.com/problems/palindrome-number/description/
// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.

class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int xGiven = x;
        int xReverse = 0;
        while (x > 0) {
            xReverse = xReverse*10 + x%10;
            x /= 10;
        }
        return xReverse == xGiven;
    }

    public boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        int lenS = s.length();
        int n = lenS / 2;
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(lenS - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
