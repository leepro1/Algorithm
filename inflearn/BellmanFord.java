package inflearn;

import java.io.*;
import java.util.*;

public class BellmanFord {

    private static int N, M;
    private static ArrayList<Edge> edges;
    private static long[] dist;
    private static final int INF = Integer.MAX_VALUE;

    private static class Edge {

        int start, end, weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        edges = new ArrayList<>();
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (bellmanFord(start)) {
            System.out.println(dist[end]);
        } else {
            System.out.println("음수 사이클이 존재합니다.");
        }
    }

    public static boolean bellmanFord(int start) {
        dist[start] = 0;

        // N-1번 반복
        for (int i = 1; i < N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.start] != INF &&
                    dist[edge.start] + edge.weight < dist[edge.end]) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        // 음수 사이클 검사
        for (Edge edge : edges) {
            if (dist[edge.start] != INF &&
                dist[edge.start] + edge.weight < dist[edge.end]) {
                return false;
            }
        }

        return true;
    }
}