package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9205 {
    static final int INF = Integer.MAX_VALUE >> 2;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n;
        Node[] nodeList;
        int[][] map;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n + 2][n + 2];

            // node 입력
            nodeList = new Node[n + 2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                nodeList[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 거리 계산
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (i == j)
                        continue;
                    map[i][j] = Math.abs(nodeList[i].x - nodeList[j].x) + Math.abs(nodeList[i].y - nodeList[j].y);

                    if (map[i][j] > 1000)
                        map[i][j] = INF;
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (map[i][k] != INF && map[k][j] != INF)
                            map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                    }
                }
            }

            if (map[0][n + 1] == INF)
                sb.append("sad\n");
            else
                sb.append("happy\n");
        }
        System.out.println(sb);
    }
}