package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707 {

    static ArrayList<Integer>[] nodeList;
    static int[] checked;

    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodeList = new ArrayList[v + 1];
            checked = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                nodeList[i] = new ArrayList<>();
            }

            while (e-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodeList[x].add(y);
                nodeList[y].add(x);
            }

            answer = false;
            for (int i = 1; i <= v; i++) {
                if (checked[i] == 0) {
                    checked[i] = 1;

                    if (bfs(i)) {
                        answer = true;
                        break;
                    }
                }
            }

            if (answer) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nextNode : nodeList[node]) {
                if (checked[nextNode] == 0) {
                    checked[nextNode] = -checked[node];
                    queue.offer(nextNode);
                } else {
                    if (checked[node] == checked[nextNode]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
