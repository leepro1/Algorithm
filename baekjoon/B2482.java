package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2482 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (n / 2 < k) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % 1_000_000_003;
            }
        }

        System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % 1_000_000_003);
    }
}
