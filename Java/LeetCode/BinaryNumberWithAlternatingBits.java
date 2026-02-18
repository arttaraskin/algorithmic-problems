// https://leetcode.com/problems/binary-number-with-alternating-bits/description
// 693. Binary Number with Alternating Bits
// EASY
/* Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:
Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:
Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011. */

class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
        //      10101010101
        //  +    1010101010    ( number >> 1 )
        //  ---------------
        //  =   11111111111
        //  &  100000000000
        //  ---------------
        //  =             0    ( power of two )
        var tmp = ( n >> 1 ) + n;
        return (tmp & tmp + 1) == 0;
    }
	
	public boolean hasAlternatingBits1(int n) {
        return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);
    }
	
	public boolean hasAlternatingBits2(int n) {
        while (n > 0) {
            var cur = n % 2;
            n = n >> 1; // n /= 2;
            if (cur == n % 2) return false;
        }
        return true;
    }
	
    public boolean hasAlternatingBits3(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
