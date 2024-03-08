package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-08
 */
public class CombinationSum39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return result;
    }
    public void backtrack(int[] candidates, int target, int currSum, int startIndex) {
        if (currSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            currSum = currSum + candidates[i];
            path.add(candidates[i]);
            if (currSum <= target) {
                backtrack(candidates, target, currSum, i);
            }
            path.remove(path.size()-1);
            currSum = currSum - candidates[i];
        }
    }
}
