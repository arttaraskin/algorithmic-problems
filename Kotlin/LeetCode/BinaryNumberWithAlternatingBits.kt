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
    fun hasAlternatingBits(n: Int): Boolean {
        //      10101010101
        //  +    1010101010    ( number >> 1 )
        //  ---------------
        //  =   11111111111
        //  &  100000000000
        //  ---------------
        //  =             0    ( power of two )
        val tmp = (n shr 1) + n
        return (tmp and (tmp + 1)) == 0
    }

    fun hasAlternatingBits1(n: Int): Boolean {
        return (n and (n shr 1)) == 0 && (n and (n shr 2)) == (n shr 2)
    }

    fun hasAlternatingBits2(n: Int): Boolean {
        var num = n
        while (num > 0) {
            val cur = num % 2
            num = num shr 1 // num /= 2
            if (cur == num % 2) return false
        }
        return true
    }

    fun hasAlternatingBits3(n: Int): Boolean {
        val bits = n.toString(2)
        for (i in 0 until bits.length - 1) {
            if (bits[i] == bits[i + 1]) {
                return false
            }
        }
        return true
    }
}
