// https://leetcode.com/problems/subsets/description/
// 78. Subsets
/* Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] */

// Backtrack / DFS pattern
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayDeque<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> subset, List<List<Integer>> result) {
        // Base case
        result.add(new ArrayList<>(subset));
        // Recursion case
        for (int i = start; i < nums.length; i++) {
            // Choose
            subset.addLast(nums[i]);
            // Explore
            backtrack(nums, i + 1, subset, result);
            // Undo/Backtrack
            subset.removeLast();
        }
    }
}


// Backtrack / DFS pattern without loop
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayDeque<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, Deque<Integer> subset, List<List<Integer>> result) {
        // Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // Recursion case
        // Choose
        subset.addLast(nums[index]);
        // Explore
        backtrack(nums, index + 1, subset, result);
        // Undo/Backtrack
        subset.removeLast();
        backtrack(nums, index + 1, subset, result);
    }
}


// Iterative / BFS pattern
class Subsets {
    /**
     * Generates all possible subsets of a given array of unique integers using iteration.
     * 
     * @param nums The input array of unique elements.
     * @return A list containing all subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        // Start with a list containing only the empty set
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        // Iterate through each number in the input array
        for (int num : nums) {
            // Get the current number of subsets we have so far
            int currentSize = result.size();
            
            // For every existing subset, create a new one by adding the current number
            for (int i = 0; i < currentSize; i++) {
                // Take an existing subset
                List<Integer> existingSubset = result.get(i);
                
                // Create a new subset by copying the existing one and adding 'num'
                List<Integer> newSubset = new ArrayList<>(existingSubset);
                newSubset.add(num);
                
                // Add the new subset to our result list
                result.add(newSubset);
            }
        }

        return result;
    }
}
