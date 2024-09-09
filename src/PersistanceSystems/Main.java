package PersistanceSystems;

import java.util.ArrayList;
import java.util.List;

/*
Persistence System L1.
Given an array of distinct integers and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

Examples:
Input: inetgers = [2,3,6,7], target = 7
 Output: [[2,2,3],[7]]

Input: candidates = [2,3,5], target = 8
 Output: [[2,2,2,2],[2,3,3],[3,5]]

Input: candidates = [2], target = 1
 Output: []
 */

public class Main {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Main cs = new Main();

        // Example 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(cs.combinationSum(candidates1, target1));
    }
}
