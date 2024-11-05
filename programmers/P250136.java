package programmers;

import java.util.*;

public class P250136 {

    static int n;
    static int m;

    static int[] answerArr;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Node> queue = new ArrayDeque<>();

    static class Node {

        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land) {

        n = land.length;
        m = land[0].length;

        answerArr = new int[m + 1];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (land[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    bfs(land);
                }
            }

        }

        int answer = 0;

        for (int i = 1; i <= m; i++) {
            answer = Math.max(answer, answerArr[i]);
        }

        return answer;
    }

    static void bfs(int[][] land) {
        int cnt = 0;
        Set<Integer> set = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            set.add(node.y);
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }

                if (visited[nx][ny] || land[nx][ny] == 0) {
                    continue;
                }

                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;

            }
        }

        for (int y : set) {
            answerArr[y + 1] += cnt;
        }
    }
}
