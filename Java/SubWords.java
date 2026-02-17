package com.task;

import java.util.*;

public class SubWords {
    public static void main(String[] args) {
        String given = "abcdea";
        String[] words = {"a", "bb", "acd", "ace", "ae", "ea", "ba", "bd", "ba"};
        System.out.println(numberOfSubWords(given, words));
        System.out.println(numberOfSubWordsHash(given, words));
    }

    public static int numberOfSubWords(String given, String[] words) {
        int counter = 0;
        for (String word : words) {
            int wordCharIndex = 0;
            for (char givenChar : given.toCharArray()) {
                if (givenChar == word.charAt(wordCharIndex)) {
                    if (wordCharIndex < word.length() - 1) {
                        wordCharIndex++;
                    } else {
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public static int numberOfSubWordsHash(String given, String[] words) {
        int counter = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < given.length(); i++) {
            if (map.containsKey(given.charAt(i))) {
                map.get(given.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(given.charAt(i), list);
            }
//            map.merge(given.charAt(i), new ArrayDeque<>(), (vOld, vDefault) -> {
//                vOld.addAll(vDefault);
//                return vOld;
//            });
        }

        for (String word : words) {
            if (isPresent(word, map)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isPresent(String word, Map<Character, List<Integer>> map) {
        int indexPrevious = -1;
        for (char w : word.toCharArray()) {
            if (map.containsKey(w)) {
                Integer indexInGiven = searchIndexInGiven(map.get(w), indexPrevious);
                if (searchIndexInGiven(map.get(w), indexPrevious) != -1) {
                    indexPrevious = indexInGiven;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static Integer searchIndexInGiven(List<Integer> listOfIndexInGiven, int indexPrevious) {
        for(Integer indexInGiven : listOfIndexInGiven) {
            if (indexPrevious < indexInGiven) {
                return indexInGiven;
            }
        }
        return -1;
    }
}
