// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// 28. Find the Index of the First Occurrence in a String
/* Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1. */

class IndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = 0;
                for (int j = i; j < haystack.length() && k < needle.length()
                    && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if (k == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
