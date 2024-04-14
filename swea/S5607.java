package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5607 {
    static final int MOD = 1_234_567_891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];
        dp[1] = 1L;
        for (int i = 2; i <= 1_000_000; i++) {
            dp[i] = dp[i - 1] * i % MOD;
        }

        int n, r;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            long facN = dp[n];
            long facR = dp[r];
            long facNR = dp[n - r];

            long answer = powFunc(facNR * facR, MOD - 2);
            answer = facN * answer % MOD;
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static long powFunc(long a, int p) {
        long temp = 1L;
        a %= MOD;

        while (p > 0) {
            if (p % 2 == 1)
                temp = (temp * a) % MOD;
            p /= 2;
            a = a * a % MOD;
        }
        return temp;
    }
}
