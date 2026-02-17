package com.task;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(List.of("Eat", "Tea", "Tan", "ate", "nat", "bat")));
    }

    public static List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> groupedAnagrams = strs.stream()
            .collect(Collectors.groupingBy(str -> {
                char[] chars = str.toLowerCase().toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }));
        return new ArrayList<>(groupedAnagrams.values());
    }

    public static List<List<String>> groupAnagrams2(List<String> strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String str : strs) {
            var chars = str.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String strSorted = new String(chars); //Arrays.toString(chars);
            if (groupedAnagrams.containsKey(strSorted)) {
                groupedAnagrams.get(strSorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                groupedAnagrams.put(strSorted, list);
            }
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
}
