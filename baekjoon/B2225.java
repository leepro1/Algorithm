package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2225 {

    static final int MOD_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= K; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD_VALUE;

            }
        }

        System.out.println(dp[N][K]);

    }
}
