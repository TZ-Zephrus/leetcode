package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumTWO40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Boolean[] used;
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new Boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return result;
    }

    //used数组
    public void backtrack(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1] && used[i-1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum = sum + candidates[i];
            used[i] = true;
            if (sum <= target) {
                backtrack(candidates, target, i+1, sum);
            }
            used[i] = false;
            sum = sum - candidates[i];
            path.remove(path.size()-1);
        }
    }

    //直接用索引
    public void backtrack0(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            sum = sum + candidates[i];
            if (sum <= target) {
                backtrack(candidates, target, i+1, sum);
            }
            sum = sum - candidates[i];
            path.remove(path.size()-1);
        }
    }
}
