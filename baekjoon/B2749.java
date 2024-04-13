package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int m = 1_000_000;
        int p = 15 * m / 10;
        int[] dp = new int[p];
        dp[1] = 1;
        for (int i = 2; i < p; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % m;
        }

        System.out.println(dp[(int) (n% (long)p)]);
    }
}
