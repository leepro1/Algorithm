package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485 {
    static final int INF = Integer.MAX_VALUE >> 2;
    static int n;
    static int[][] map, dist;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; true; t++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            map = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
            }

            dijkstra();

            sb.append("Problem " + t + ": " + dist[n - 1][n - 1] + "\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (dist[nx][ny] > dist[temp.x][temp.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[temp.x][temp.y] + map[nx][ny];
                    pq.offer(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }

    }
}
