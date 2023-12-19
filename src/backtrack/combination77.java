package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combination77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    public void backtrack(int n, int k, int startindex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i <= n - (k-path.size())+1; i++) {
            path.add(startindex);
            backtrack(n, k, i);
            path.remove(path.size()-1);
        }
    }
}
