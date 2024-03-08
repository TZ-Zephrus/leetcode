package hot100.graph_theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-06
 */
public class AllPathInDAG797 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return result;
    }
    public void dfs(int[][] graph, int i) {
        if (i == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            path.add(graph[i][j]);
            dfs(graph, graph[i][j]);
            path.remove(path.size()-1);
        }
    }
}
