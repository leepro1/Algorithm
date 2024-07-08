package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {

    static int N, E;
    static ArrayList<Node>[] nodeList;
    static boolean[] visited;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, cost));
            nodeList[end].add(new Node(start, cost));
        }


        int[] check = new int[4];
        check[0] = 1;
        check[3] = N;
        st = new StringTokenizer(br.readLine());
        check[1] = Integer.parseInt(st.nextToken());
        check[2] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dijkstra(check[i], check[i + 1]);
            if (sum > Integer.MAX_VALUE >> 2) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        int sum2 = 0;
        int temp = check[1];
        check[1] = check[2];
        check[2] = temp;
        for (int i = 0; i < 3; i++) {
            sum2 += dijkstra(check[i], check[i + 1]);
            if (sum2 > Integer.MAX_VALUE >> 2) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(Math.min(sum, sum2));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE >> 2);
        dist[start] = 0;

        visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.end]) {
                visited[node.end] = true;

                for (Node next : nodeList[node.end]) {

                    if (!visited[next.end] && dist[next.end] > dist[node.end] + next.cost) {
                        dist[next.end] = dist[node.end] + next.cost;
                        pq.add(new Node(next.end, dist[next.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
