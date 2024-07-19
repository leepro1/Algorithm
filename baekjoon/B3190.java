package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B3190 {

    static int N, K, L;
    static int[][] map;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
        }

        L = Integer.parseInt(br.readLine());
        int[] mission = new int[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("D"))
                mission[i] = second;
            else
                mission[i] = -second;
        }

        int second = 1;
        int direction = 0;
        int missionNum = 0;
        int missionValue = Math.abs(mission[0]);
        ArrayDeque<Node> snake = new ArrayDeque<>();
        snake.add(new Node(0, 0));
        map[0][0] = 1;

        while (true) {
            assert snake.peek() != null;
            int nx = snake.peek().x + dx[direction];
            int ny = snake.peek().y + dy[direction];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1)
                break;

            if (map[nx][ny] != -1) {
                Node removeNode = snake.pollLast();
                map[removeNode.x][removeNode.y] = 0;
            }

            snake.addFirst(new Node(nx, ny));
            map[nx][ny] = 1;

            if (second == missionValue) {
                if (mission[missionNum] < 0) {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }

                if (missionNum < L - 1) {
                    missionValue = Math.abs(mission[++missionNum]);
                }
            }

            second++;
        }

        System.out.println(second);
    }
}
