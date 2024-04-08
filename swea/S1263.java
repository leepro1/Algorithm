package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n, answer;
        int[][] dp;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        final int INF = Integer.MAX_VALUE >> 2;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dp = new int[n][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && dp[i][j] == 0)
                        dp[i][j] = INF;
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }

            answer = INF;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] != INF)
                        dp[i][n] += dp[i][j];
                }
                if (answer > dp[i][n]) {
                    answer = dp[i][n];
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
