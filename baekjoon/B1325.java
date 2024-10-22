package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 {
    static ArrayList<Integer>[] nodeList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList[b].add(a);
        }

        int max = 0;
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int cnt = bfs(i);
            answer[i] = cnt;
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (answer[i] == max)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : nodeList[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    queue.offer(next);
                }
            }
        }
        return cnt;
    }
}
