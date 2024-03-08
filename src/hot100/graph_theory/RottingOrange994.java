package hot100.graph_theory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-06
 */
public class RottingOrange994 {
    int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    boolean[][] visited;
    public int orangesRotting(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> deque = new LinkedList<>();
        int orangeNum = 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    orangeNum++;
                } else if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    deque.add(new int[]{i, j});
                }
            }
        }
        // 这里是bfs
        while (!deque.isEmpty()) {
            result++;
            int size = deque.size();
            // 需要多一层循环，用来记录轮数
            for (int count = 0; count < size; count++) {
                int[] arr = deque.poll();
                int x = arr[0];
                int y = arr[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dir[i][0];
                    int nextY = y + dir[i][1];
                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                        visited[nextX][nextY] = true;
                        orangeNum--;
                        deque.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return orangeNum == 0 ? result:-1;
    }
}
