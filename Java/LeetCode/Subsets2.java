// https://leetcode.com/problems/subsets-ii/description/
// 90. Subsets II
/* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]] */

class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayDeque<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> subset, List<List<Integer>> result) {
        // Base case
        result.add(new ArrayList<>(subset));
        // Recursion case
        for (int i = start; i < nums.length; i++) {
            // Constraint: skip duplicates
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            // Choose
            subset.addLast(nums[i]);
            // Explore
            backtrack(nums, i + 1, subset, result);
            // Undo/Backtrack
            subset.removeLast();
        }
    }
}
