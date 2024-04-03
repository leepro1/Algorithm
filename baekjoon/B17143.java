package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 636ms    28,256kb
public class B17143 {

    static int answer = 0;

    static int R, C, M;
    static int[][][] map;
    static List<Shark> sharkList = new ArrayList<>();

    // 위 오른쪽 아래 왼쪽
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Shark implements Comparable<Shark> {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return this.z - o.z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1][C + 1];
        sharkList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 방향 조작
            if (d == 3)
                d = 2;
            else if (d == 2)
                d = 3;

            d--;

            // 속도 조작
            if (d % 2 == 0)
                s %= (R * 2 - 2);
            else
                s %= (C * 2 - 2);

            sharkList.add(new Shark(r, c, s, d, z));
        }

        for (int i = 1; i <= C; i++) {
            solve(i);
        }
        System.out.println(answer);
    }

    static void solve(int cnt) {

        // 낚시하기
        int target = M + 1;
        int targetRow = R + 1;
        for (int i = 0, size = sharkList.size(); i < size; i++) {
            if (sharkList.get(i).c == cnt && sharkList.get(i).r < targetRow) {
                targetRow = sharkList.get(i).r;
                target = i;
            }
        }

        if (target != M + 1) {
            answer += sharkList.get(target).z;
            sharkList.remove(target);
        }

        if (C == cnt)
            return;

        Collections.sort(sharkList);

        // 상어 이동하기
        for (int i = sharkList.size() - 1; i >= 0; i--) {
            Shark shark = sharkList.get(i);

            move(shark);

            if (map[shark.r][shark.c][cnt] == 0) {
                map[shark.r][shark.c][cnt] = i;
            }else{
                sharkList.remove(i);
            }
        }
    }

    static void move(Shark shark) {
        if (shark.d % 2 == 0) {
            int nr = shark.r;

            for (int i = 1; i <= shark.s; i++) {
                nr += dr[shark.d];
                if (nr == 0) {
                    nr = 2;
                    shark.d = (shark.d + 2) % 4;
                } else if (nr == R + 1) {
                    nr = R - 1;
                    shark.d = (shark.d + 2) % 4;
                }
            }
            shark.r = nr;
        } else {
            int nc = shark.c;

            for (int i = 1; i <= shark.s; i++) {
                nc += dc[shark.d];
                if (nc == 0) {
                    nc = 2;
                    shark.d = (shark.d + 2) % 4;
                } else if (nc == C + 1) {
                    nc = C - 1;
                    shark.d = (shark.d + 2) % 4;
                }
            }
            shark.c = nc;
        }
    }
}