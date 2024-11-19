package inflearn;

import java.io.*;
import java.util.*;

public class FloydWarshall {

    private static int N, M;
    private static int[][] dist;
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        dist = new int[N + 1][N + 1];

        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[start][end] = Math.min(dist[start][end], weight);
        }

        // 플로이드-워셜 알고리즘 수행
        floydWarshall();

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],
                            dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}
