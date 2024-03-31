package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B3055 {
    static int r, c;
    static char[][] map;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayDeque<Node> queue = new ArrayDeque<Node>();

    static class Node {
        int x, y, time;
        boolean flag;

        public Node(int x, int y, int time, boolean flag) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S')
                    queue.add(new Node(i, j, 0, true));

                if (map[i][j] == '*')
                    queue.addFirst(new Node(i, j, 0, false));
            }
        }

        bfs();
        System.out.println("KAKTUS");
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node temp = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == 'X')
                    continue;

                if (temp.flag) {
                    if (map[nx][ny] == 'D') {
                        System.out.println(temp.time + 1);
                        System.exit(0);
                    }

                    if (map[nx][ny] != '*' && map[nx][ny] != 'S') {
                        queue.add(new Node(nx, ny, temp.time + 1, true));
                        map[nx][ny] = 'S';
                    }
                } else {
                    if (map[nx][ny] != 'D' && map[nx][ny] != '*') {
                        queue.add(new Node(nx, ny, temp.time + 1, false));
                        map[nx][ny] = '*';
                    }
                }
            }
        }
    }
}