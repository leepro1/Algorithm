package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2565 {

    static class Node implements Comparable<Node> {
        int index, cnt;

        Node(int index) {
            this.index = index;
            this.cnt = 0;
        }

        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList[] nodeList = new ArrayList[501];
        Node[] node = new Node[501];
        int[] edge = new int[501];

        for (int i = 1; i <= 500; i++) {
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edge[start] = end;
            node[start] = new Node(start);
        }

        int[] cnt = new int[501];
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j < i; j++) {
                if (edge[i] > edge[j]) {
                    nodeList[i].add(j);
                    nodeList[j].add(i);
                    node[i].cnt++;
                    node[j].cnt++;
                    cnt[i]++;
                    cnt[j]++;
                }
            }
            for (int j = i + 1; j <= 500; j++) {
                if (edge[i] < edge[j]) {
                    nodeList[i].add(j);
                    nodeList[j].add(i);
                    node[i].cnt++;
                    node[j].cnt++;
                    cnt[i]++;
                    cnt[j]++;
                }
            }
        }

        Arrays.sort(node);

        int answer = 0;
        boolean[] visited= new boolean[501];
        for (int i = 0; node[i] != null; i++) {
            if (cnt[node[i].index] == 0)
                continue;

            visited[node[i].index] = true;

            answer++;
            for (int j = 0; j < nodeList[node[i].index].size(); j++) {
                if(visited[(int) nodeList[node[i].index].get(j)])
                    continue;

                cnt[(int) nodeList[node[i].index].get(j)]--;
                cnt[node[i].index]--;
            }
        }

        System.out.println(answer);
    }
}
