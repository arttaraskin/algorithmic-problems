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

class LetterCombinationsDFS {
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
    private char[] inputDigits;
    private final StringBuilder combination = new StringBuilder();
    // private final Deque<Character> combination = new ArrayDeque<>();
    private final List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
		if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
		
        inputDigits = digits.toCharArray();
        backtrack(0);
        return result;
    }

    // Depth-First Search (DFS) / Backtracking
    private void backtrack(int index) {
        // Base case
        if (index == inputDigits.length) {
            result.add(combination.toString());
            //result.add(String.join("", combination));
            return;
        }
        // Iterate through all possible letters for the current digit
        String letters = DIGIT_TO_LETTERS.get(inputDigits[index]);
        for (char letter : letters.toCharArray()) {
            // Choose: Append the letter
            combination.append(letter);
            // combination.addLast(letter);

            // Explore: Recurse to the next digit
            backtrack(index + 1);

            // Unchoose (Backtrack): Remove the last letter to try the next option
            combination.deleteCharAt(combination.length() - 1);
            // combination.removeLast();
        }
    }
}
