// https://leetcode.com/problems/generate-parentheses/description/
// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]

class BacktrackingParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }

        check(n, 0, "", list);
        return list;
    }

    private static void check(int left, int right, String result, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(result);
            return;
        }

        if (left > 0) {
            check(left - 1, right + 1, result + "(", list);
        }
        if (right > 0) {
            check(left, right - 1, result + ")", list);
        }
    }
}
