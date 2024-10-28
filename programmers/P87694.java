package programmers;

import java.util.*;

class P87694 {

    static char[][] map = new char[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            draw(y1, x1, y2, x2);
        }
        return bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
    }

    public static void draw(int y1, int x1, int y2, int x2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (map[i][j] == '1') {
                    continue;
                }
                map[i][j] = '1';
                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = '2';
                }
            }
        }
    }

    public static int bfs(int startY, int startX, int targetY, int targetX) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startY, startX, 0});
        boolean[][] visited = new boolean[101][101];
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int y = current[0], x = current[1], count = current[2];

            if (y == targetY && x == targetX) {
                return count / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] != '2') {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.add(new Integer[]{nextY, nextX, count + 1});
            }
        }
        return 0;
    }
}
