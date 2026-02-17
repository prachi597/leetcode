import java.util.*;

class Solution {
    public void solve(int idx, int target, int[] arr,
                      List<Integer> cur, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (idx == arr.length || target < 0) return;

        cur.add(arr[idx]);
        solve(idx, target - arr[idx], arr, cur, ans);
        cur.remove(cur.size() - 1);

        solve(idx + 1, target, arr, cur, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
}