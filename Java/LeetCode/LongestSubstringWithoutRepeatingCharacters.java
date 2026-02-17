LongestSubstringWithoutRepeatingCharacters

class Solution {
	// Using 2 pointers and Map with last seen position
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            lastSeen.put(c, right);
        }

        return maxLength;       
    }
	
	// Using 2 pointers and Set
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
	
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> symbols = new HashMap<>();
        int counter = 0;
        int max = 0;
        //for (char symbol : s.toCharArray()) {
        int i = 0;
        while (i < s.length()) {
            char symbol = s.charAt(i);
            if (symbols.containsKey(symbol)) {
                if (max < counter) {
                    max = counter;
                }
                counter = 0;
                i = symbols.get(symbol) + 1;
                symbols.clear();
            } else {
                symbols.put(symbol, i);
                counter++;
                i++;
            }
        }
        return max > counter ? max : counter;
    }
	
	
	public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> symbols = new HashMap<>();
        int counter = 0;
        int max = 0;
        //for (char symbol : s.toCharArray()) {
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbols.containsKey(symbol)) {
                if (max < counter) {
                    max = counter;
                }
                int idx = symbols.get(symbol);
                symbols.values().removeIf(v -> v <= idx);
                counter = symbols.size();
            }
            symbols.put(symbol, i);
            counter++;
        }
        return max > counter ? max : counter;
    }
}
