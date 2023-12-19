package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSumTHREE216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return result;
    }

    public void backtrack(int k, int n , int startIndex, int sum) {
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        } else if (path.size() == k) {
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum = sum+i;
            if (sum <= n) {
                backtrack(k, n, i + 1, sum);
            }
            sum = sum-i;
            path.remove(path.size()-1);
        }
    }
}
