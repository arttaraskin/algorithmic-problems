// https://leetcode.com/problems/reverse-bits/description
// 190. Reverse Bits
/* Reverse bits of a given 32 bits signed integer.

Example 1:
Input: n = 43261596
Output: 964176192
Explanation:
Integer	    Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000 */

class ReverseBits {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}

class ReverseBits {
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0b11111111000000001111111100000000) >>> 8)
          | ((n & 0b00000000111111110000000011111111) << 8);
        n = ((n & 0b11110000111100001111000011110000) >>> 4)
          | ((n & 0b00001111000011110000111100001111) << 4);
        n = ((n & 0b11001100110011001100110011001100) >>> 2)
          | ((n & 0b00110011001100110011001100110011) << 2);
        n = ((n & 0b10101010101010101010101010101010) >>> 1)
          | ((n & 0b01010101010101010101010101010101) << 1);
        return n;
    }
}

class ReverseBits {
    private static final int LEN = 32;
    public int reverseBits(int n) {
        if (n == 0 | n == 1) {
            return n;
        }

        var bs = BitSet.valueOf(new long[] { n });
        for (int i = 0; i < LEN / 2; i++) {
            var temp = bs.get(i);
            bs.set(i, bs.get(LEN - i - 1));
            bs.set(LEN - i - 1, temp);
        }
        return (int) bs.toLongArray()[0];
    }
}
