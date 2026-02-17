import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates); // important for duplicate handling

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] arr, int target, int start,
                           List<Integer> temp, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // skip duplicates
            if (i > start && arr[i] == arr[i - 1])
                continue;

            // stop if number is too big
            if (arr[i] > target)
                break;

            temp.add(arr[i]); // choose
            backtrack(arr, target - arr[i], i + 1, temp, result);
            temp.remove(temp.size() - 1); // undo (backtrack)
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(s.combinationSum2(candidates, target));
    }
}