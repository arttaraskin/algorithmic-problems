// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description
// 1930. Unique Length-3 Palindromic Subsequences
/* Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
A palindrome is a string that reads the same forwards and backwards.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
 
Example 1:
Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:
Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:
Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba") */

class UniqueLengthPalindromicSubsequences {
    public int countPalindromicSubsequence1(String s) {
        Set<Character> letters = new HashSet();
        int ans = 0;
        for (int start = 0; start < s.length(); start++) {
            char c = s.charAt(start);
            if (!letters.contains(c)) {
                letters.add(c);
                int end = -1;
                for (int pos = s.length() - 1; pos > start + 1; pos--) {
                    if (s.charAt(pos) == c) {                     
                        end = pos;
                        break;
                    }
                }

                Set<Character> between = new HashSet();
                for (int i = start + 1; i < end; i++) {
                    between.add(s.charAt(i));
                }
                ans += between.size();
            }
        }
        return ans;
    }
	
	// Find first and last position of letters (taking into account that there are only letters in the given string)
	// Using of bitmask instead of set improve perfomance sifnificantly
    public int countPalindromicSubsequence2(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == - 1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        int ans = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) {
                continue;
            }

            int between = 0;
            for (int i = first[c] + 1; i < last[c]; i++) {
                between |= 1 << (s.charAt(i) - 'a');
            }
            ans += Integer.bitCount(between);
        }
        return ans;
    }
}
