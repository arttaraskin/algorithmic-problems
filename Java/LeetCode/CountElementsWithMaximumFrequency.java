// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
// 3005. Count Elements With Maximum Frequency
/* You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.

Example 1:
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
Example 2:
Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5. */

class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        byte[] frequencies = new byte[101];
        byte max = 0, res = 0;
        for (int n : nums) {
            byte frequency = ++frequencies[n];
            if (frequency > max) {
                max = frequency;
                res = frequency;
            } else if (frequency == max)
                res += frequency;
        }
        return res;
    }
	
    public int maxFrequencyElements2(int[] nums) {
        var frequencies = new HashMap<Integer, Integer>();
        int maxFrequency = 0;
        int totalFrequencies = 0;
        for (int num : nums) {
            int frequency = frequencies.getOrDefault(num, 0);
            frequencies.put(num, ++frequency);
            // If we discover a higher frequency element
            // Update maxFrequency
            // Re-set totalFrequencies to the new max frequency
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                totalFrequencies = frequency;
                // If we find an element with the max frequency, add it to the total
            } else if (frequency == maxFrequency) {
                totalFrequencies += frequency;
            }
        }
        return totalFrequencies;
    }
}
