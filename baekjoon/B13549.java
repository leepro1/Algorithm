package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 {

    static class Node implements Comparable<Node> {
        int point;
        int cnt;

        Node(int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100_001];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(visited[temp.point]) continue;
            visited[temp.point] = true;

            if (temp.point == K) {
                System.out.println(temp.cnt);
                return;
            }

            if (temp.point * 2 <= 100_000 && !visited[temp.point * 2]) {
                queue.add(new Node(temp.point * 2, temp.cnt));
            }

            if (temp.point - 1 >= 0 && !visited[temp.point - 1]) {
                queue.add(new Node(temp.point - 1, temp.cnt + 1));
            }

            if (temp.point + 1 <= 100_000 && !visited[temp.point + 1]) {
                queue.add(new Node(temp.point + 1, temp.cnt + 1));
            }

        }

    }
}
