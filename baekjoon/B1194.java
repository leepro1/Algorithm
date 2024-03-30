package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B1194 {
    static int n, m, answer = -1;
    static char[][] map;
    static int[][][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static ArrayDeque<Node> queue = new ArrayDeque<>();

    static class Node {
        int x, y, bit, cnt;

        public Node(int x, int y, int bit, int cnt) {
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m][64];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0')
                    queue.add(new Node(i, j, 0, 0));
            }
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (map[temp.x][temp.y] == '1') {
                answer = temp.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#')
                    continue;

                if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if ((temp.bit & (1 << (map[nx][ny] - 'A'))) == 0)
                        continue;
                }

                int tempBit = temp.bit;

                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    if ((temp.bit & (1 << (map[nx][ny] - 'a'))) == 0)
                        tempBit |= 1 << (map[nx][ny] - 'a');
                }


                if (visited[nx][ny][tempBit] == 0) {
                    queue.add(new Node(nx, ny, tempBit, temp.cnt + 1));
                    visited[nx][ny][tempBit] = temp.cnt + 1;
                }
            }
        }
    }
}