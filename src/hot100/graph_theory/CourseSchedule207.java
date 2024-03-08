package hot100.graph_theory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-07
 */
public class CourseSchedule207 {
    // bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Deque<Integer> deque = new LinkedList<>();
        // 生成初始入度表
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        // 将入度为0的节点加入队列
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            numCourses--;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == node) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        deque.add(prerequisites[i][0]);
                    }
                }
            }
        }
        System.out.println(numCourses);
        return numCourses == 0 ? true : false;
    }

    // dfs
    int[] flag;
    boolean valid = true;
    List<List<Integer>> edges;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        flag = new int[numCourses];
        // 生成邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 开始进行dfs
        for (int i = 0; i < flag.length; i++) {
            dfs(i);
        }
        return valid;
    }
    public boolean dfs(int u) {
        if (flag[u] == 1) {
            valid = false;
            return valid;
        }
        if (flag[u] == -1) {
            return true;
        }
        flag[u] = 1;
        for (Integer i : edges.get(u)) {
            if (!dfs(i)) {
                return valid;
            }
        }
        return valid;
    }
}
