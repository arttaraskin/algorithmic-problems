// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// 17. Letter Combinations of a Phone Number
/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters is just like on the telephone buttons. Note that 1 does not map to any letters.
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = "2"
Output: ["a","b","c"] */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationsBFS {
    private static final Map<Character, String> DIGIT_TO_LETTERS = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(""); // Start with an empty combination

        for (char digit : digits.toCharArray()) {
            String letters = DIGIT_TO_LETTERS.get(digit);
            int queueSize = queue.size();

            // Process all combinations currently in the queue (from the previous level)
            for (int i = 0; i < queueSize; i++) {
                String currentCombination = queue.poll();
                
                // Expand the current combination with all letters of the current digit
                for (char letter : letters.toCharArray()) {
                    queue.add(currentCombination + letter);
                }
            }
        }
        
        // Convert the final queue content to a List
        return new ArrayList<>(queue);
    }
}
