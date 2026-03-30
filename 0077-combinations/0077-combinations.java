import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtrack(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}