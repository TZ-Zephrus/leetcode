package hot100.graph_theory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-06
 */
public class NumberOfIslands200 {
    int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    boolean[][] visited;
    // 深搜法dfs
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    public  void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (visited[x][y] == true || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            dfs(grid, nextX, nextY);
        }
    }

    // 广搜法dfs
    public int numIslands2(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    public void bfs(char[][] grid, int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{x, y});
        visited[x][y] = true;
        while (!deque.isEmpty()) {
            int[] arr = deque.poll();
            x = arr[0];
            y = arr[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length){
                    continue;
                }
                if (visited[nextX][nextY] == false && grid[nextX][nextY] == '1') {
                    visited[nextX][nextY] = true;
                    deque.push(new int[]{nextX, nextY});
                }
            }
        }
    }
}
