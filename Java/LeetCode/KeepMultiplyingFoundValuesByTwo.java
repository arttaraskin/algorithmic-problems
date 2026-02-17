// https://leetcode.com/problems/keep-multiplying-found-values-by-two/description
// 2154. Keep Multiplying Found Values by Two
/* You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.
You then do the following steps:
If original is found in nums, multiply it by two (i.e., set original = 2 * original).
Otherwise, stop the process.
Repeat this process with the new number as long as you keep finding the number.
Return the final value of original.

Example 1:
Input: nums = [5,3,6,1,12], original = 3
Output: 24
Explanation: 
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.

Example 2:
Input: nums = [2,7,9], original = 4
Output: 4
Explanation:
- 4 is not found in nums. Thus, 4 is returned. */

package com.task;

import java.util.*;
import java.util.stream.Collectors;

public class KeepMultiplyingFoundValuesByTwo {
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{2, 4, 1, 8}, 2));
    }

    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValue2(int[] nums, int original) {
        int mask = 0;
        for (int num : nums) {
            if (num % original == 0) {
                int n = num / original;
                if (isPowerOfTwo(n)) {
                    mask |= n;
                }
            }
        }
        int multiplier = (mask + 1) & ~mask;
        return original * multiplier;
    }

    private static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
