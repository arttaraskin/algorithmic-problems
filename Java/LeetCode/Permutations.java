package com.task;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    private final List<List<Integer>> result = new ArrayList<>();
    private final Deque<Integer> permutation = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        // Base case
        if (permutation.size() == nums.length) {
            result.add(new ArrayList(permutation));
            return;
        }

        for (Integer num : nums) {
            // Constraint
            if (permutation.contains(num))  {
                continue;
            }
			// Choose
            permutation.push(num);
			// Explore
            backtrack(nums);
			// Undo/Backtrack
            permutation.pop();
        }
    }
	
	
	private void backtrackWithSwap(int[] nums, int start) {
        // Base case
        if (start == nums.length) {
            List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(listNums);
            return;
        }
        // Recursion case
        for (int i = start; i < nums.length; i++) {
            // Swap
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            
            backtrack(nums, start + 1);
            
            // Swap back
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
}
