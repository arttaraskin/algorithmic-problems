// https://leetcode.com/problems/valid-parentheses/description/
/* 20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type. */

package com.task;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    private static final Map<Character, Character> PAIR = Map.of('(',')','{','}','[',']');;

    public static boolean isValid(String s) {
        final Deque<Character> deque = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
        for(char c: s.toCharArray()) {
            if (PAIR.containsKey(c)) {
                deque.addLast(c);
            } else {
                if (deque.isEmpty() || !(PAIR.get(deque.pollLast()).equals(c))) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static boolean isValid2(String s) {
        int prevLength = 0;
        while(!s.isEmpty() && s.length() != prevLength) {
            prevLength = s.length();
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }
	
	public boolean isValid3(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
