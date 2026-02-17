// https://leetcode.com/problems/permutations-ii/description/
// 47. Permutations II
/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]] */

class PermutationsDuplicates {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // Sort the array to handle duplicates efficiently
        Arrays.sort(nums);
        // Start the backtracking process
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> permutations, int [] nums, boolean [] used){
        // Base case: If the permutation is complete
        if(permutations.size() == nums.length){
            result.add(new ArrayList<>(permutations));
            return;
        }
        // Recursion case
        for(int i = 0; i < nums.length; i++){
            // Constraints:
            // Check if the number has already been used in the current path
            if (used[i]) {
                continue;
            }
            // DUPES HANDLING:
            // If the current number is the same as the previous number AND the previous number 
            // was NOT used (meaning we are at the same level of the recursion tree, exploring alternatives), 
            // we skip it to avoid duplicate permutations.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // Choose
            permutations.add(nums[i]);
            used[i] = true;
            // Explore
            backtrack(result, permutations, nums, used);
            // Undo/Backtrack
            permutations.remove(permutations.size() - 1);
            used[i] = false;
		}
    }
}


// Using Map with duplicates count
class PermutationsDuplicates {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        int[] input =  new int[countMap.size()];
        int[] count =  new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            input[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        // Start the backtracking process
        int[] permutations = new int[input.length];
        backtrack(input, count, permutations, 0, result);
        return result;
    }

    private static void backtrack(int[] input, int[] count, int[] permutations, int level, List<List<Integer>> result) {
        // Base case: If the permutation is complete
        if (permutations.length == level) {
            result.add(Arrays.stream(permutations).boxed().collect(Collectors.toList()));
            return;
        }
        // Recursion case
        for (int i = 0; i < input.length; i++) {
            // Constraints:
            // Check if the number is used
            if (count[i] == 0) {
                continue;
            }
            // Choose
            permutations[level] = input[i];
            count[i]--;
            // Explore
            backtrack(input, count, permutations, level + 1, result);
            // Undo/Backtrack
            count[i]++;
        }
    }
}
