package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15681 {

    static int N, R, Q;
    static int[] dp;
    static boolean[] visited;
    static ArrayList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        visited = new boolean[N + 1];
        nodeList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[R] = true;
        cntSubTree(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {

            int target = Integer.parseInt(br.readLine());

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }

    static int cntSubTree(int node) {

        int cnt = 1;

        for (int next : nodeList[node]) {

            if(visited[next])
                continue;

            visited[next] = true;

            cnt += cntSubTree(next);
        }

        dp[node] = cnt;
        return cnt;
    }



}
