// https://leetcode.com/problems/roman-to-integer/description/
// 13. Roman to Integer

class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> digits = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);
        s.toCharArray();
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if((i < s.length() - 1) && (digits.get(s.charAt(i)) < digits.get(s.charAt(i + 1)))) {
                sum -= digits.get(s.charAt(i));
            } else {
                sum += digits.get(s.charAt(i));
            }
        }
        return sum;
    }
}

class RomanToInteger {
    public static int romanToInt(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}
