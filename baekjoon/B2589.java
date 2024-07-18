package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {

    static int X, Y;
    static int answer = 0;
    static boolean[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new boolean[X][Y];
        for (int i = 0; i < X; i++) {
            String str = br.readLine();
            for (int j = 0; j < Y; j++) {
                if (str.charAt(j) == 'L')
                    map[i][j] = true;
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!map[i][j])
                    continue;
                visited = new boolean[X][Y];
                bfs(i, j);
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            answer = Math.max(answer, node.cnt);

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y || !map[nx][ny] || visited[nx][ny])
                    continue;

                queue.add(new Node(nx, ny, node.cnt + 1));
                visited[nx][ny] = true;
            }
        }
    }
}
