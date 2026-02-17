//https://leetcode.com/problems/plus-one/description/
//66. Plus One
//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least //significant in left-to-right order. The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.

class PlusOne {
    public int[] plusOne(int[] digits) {
        int increment = 1;
    
        for (int i = digits.length - 1; i >= 0; i--) {
            int newNumber = digits[i] + increment;
            if (newNumber < 10) {
                digits[i] = newNumber;
                return digits;
            } else {
                digits[i] = newNumber % 10;
                increment = newNumber/10;
            }
        }

        if (increment > 0) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[0] = increment;
            digits = temp;
        }
        return digits;
    }
}
