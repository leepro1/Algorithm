package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5643 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N, M;
        int[] cnt;
        boolean[][] map;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            map = new boolean[N + 1][N + 1];

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i < +N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (!map[i][j] && map[i][k] && map[k][j])
                            map[i][j] = true;
                    }
                }
            }


            cnt = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j]) {
                        cnt[j]++;
                        cnt[i]++;
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == N - 1)
                    answer++;
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
