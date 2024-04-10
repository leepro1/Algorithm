package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 320ms    25248kb
public class B17144 {
    static int R, C, T;
    static int airCleaner; // 공기청정기의 아래 행 저장

    static int[][][] map;

    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C][T + 1];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());

                if (map[i][j][0] == -1)
                    airCleaner = i;
            }
        }

        for (int i = 1; i <= T; i++) {
            diffusion(i);

            clean(true, i); // 위 청소
            clean(false, i); // 아래청소
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += map[i][j][T];
            }
        }
        System.out.println(answer);
    }

    static void diffusion(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int amount = map[i][j][time - 1];
                int cnt = 0;

                if (amount == -1)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int nextR = i + dr[k];
                    int nextC = j + dc[k];

                    if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C || map[nextR][nextC][0] == -1) {
                        continue;
                    }

                    map[nextR][nextC][time] += amount / 5;
                    cnt++;
                }

                map[i][j][time] += amount - cnt * (amount / 5);
            }
        }
    }

    static void clean(boolean flag, int time) {
        int direction, cnt;
        int nowR, nowC;
        if (flag) {
            direction = 0;
            nowR = airCleaner - 2;
            nowC = 0;
            cnt = 2 * C + (airCleaner * 2) - 5;
        } else {
            direction = 2;
            nowR = airCleaner + 1;
            nowC = 0;
            cnt = 2 * C + (R - airCleaner) * 2 - 5;
        }

        while (cnt-- > 0) {

            int nextR = nowR + dr[direction];
            int nextC = nowC + dc[direction];

            if (flag && (nextR < 0 || nextC < 0 || nextR >= airCleaner || nextC >= C)) {
                direction = (direction + 1) % 4;
                nextR = nowR + dr[direction];
                nextC = nowC + dc[direction];
            }

            if (!flag && (nextR < airCleaner || nextC < 0 || nextR >= R || nextC >= C)) {
                direction--;
                if (direction == -1)
                    direction = 3;

                nextR = nowR + dr[direction];
                nextC = nowC + dc[direction];
            }

            map[nowR][nowC][time] = map[nextR][nextC][0] == -1 ? 0 : map[nextR][nextC][time];
            nowR = nextR;
            nowC = nextC;
        }
    }
}
