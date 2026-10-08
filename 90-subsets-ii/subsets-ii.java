import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates adjacent to each other
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same depth level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include nums[i] in the current subset
            current.add(nums[i]);
            
            // Move to the next element
            backtrack(nums, i + 1, current, result);
            
            // Backtrack to explore other choices
            current.remove(current.size() - 1);
        }
    }
}