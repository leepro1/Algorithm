package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5656 {

    static int N, W, H, min;
    static int[] order;

    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

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

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 마지막 행에는 각 열의 벽돌이 있는 첫 index 저장
            map = new int[H + 1][W];

            for (int i = 0; i < W; i++) {
                map[H][i] = -1;
            }

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[H][j] == -1 && map[i][j] != 0)
                        map[H][j] = i;
                }
            }

            min = W * H;
            order = new int[N];
            permutation(0);

            sb.append("#" + t + " " + min + "\n");
        }
        System.out.println(sb);
    }

    static void permutation(int depth) {
        if (depth == N) {
            bfs();
            return;
        }

        for (int i = 0; i < W; i++) {
            order[depth] = i;
            permutation(depth + 1);
        }
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();

        int[][] tempMap = new int[H + 1][W];
        for (int i = 0; i <= H; i++) {
            if (W >= 0) System.arraycopy(map[i], 0, tempMap[i], 0, W);
        }

        for (int i = 0; i < N; i++) {
            if (tempMap[H][order[i]]==-1)
                continue;
            queue.add(new Node(tempMap[H][order[i]], order[i]));

            while (!queue.isEmpty()) {
                Node temp = queue.poll();

                if (tempMap[temp.x][temp.y] == 0)
                    continue;

                int cnt = tempMap[temp.x][temp.y];
                tempMap[temp.x][temp.y] = 0;

                for (int j = 0; j < 4; j++) {
                    for (int k = 1; k < cnt; k++) {
                        int nx = temp.x + k * dx[j];
                        int ny = temp.y + k * dy[j];

                        if (nx < 0 || nx >= H || ny < 0 || ny >= W || tempMap[nx][ny] == 0)
                            continue;

                        queue.add(new Node(nx, ny));
                    }
                }
            }

            for (int j = 0; j < W; j++) {
                int limit = tempMap[H][j];

                if(limit==-1)
                    continue;

                Queue<Integer> tempQueue = new ArrayDeque<>();
                for (int k = H - 1; k >= limit; k--) {
                    if (tempMap[k][j] != 0) {
                        tempQueue.add(tempMap[k][j]);
                        tempMap[k][j] = 0;
                    }
                }

                limit = tempQueue.size();
                for (int k = H - 1; !tempQueue.isEmpty(); k--) {
                    tempMap[k][j] = tempQueue.poll();
                }

                tempMap[H][j] = H - limit;
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            if(tempMap[H][i]!=-1)
                sum += H - tempMap[H][i];
        }
        min = Math.min(min, sum);
    }
}
