// https://leetcode.com/problems/1-bit-and-2-bit-characters/description
// 717. 1-bit and 2-bit Characters
/* We have two special characters:
The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
Example 1:
Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
Example 2:
Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character. */

class OneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0 || bits[bits.length - 1] == 1) {
            return false;
        }

        int count1s = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] == 1; i--) {
            count1s++;
        }
        return count1s % 2 == 0;
    }
}


/* When reading from the i-th position, if bits[i] == 0, the next character must be at i + 1, because 0 is 1-bit; else if bits[i] == 1, the next character must be at i + 2, because 1 is only present in 2-bit characters 10 and 11. We increment our read-pointer i to the start of the next character appropriately. At the end, if our pointer is at bits.length - 1, then the last character must have a size of 1 bit. */
class OneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}

