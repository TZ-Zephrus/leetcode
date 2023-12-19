package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSum39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return result;
    }
    public void backtrack(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            if (sum <= target) {
                backtrack(candidates, target, i,  sum);
            }
            sum = sum - candidates[i];
            path.remove(path.size()-1);
        }
    }
}
