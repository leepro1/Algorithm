package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16134 {
    static int N, R;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        if (R == 0 || R == N) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[N + 1];
        dp[1] = 1L;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] * i % MOD;
        }

        long facN = dp[N];
        long facR = dp[R];
        long facNR = dp[N - R];

        long answer = power((facNR * facR) % MOD, MOD - 2);
        answer = facN * answer % MOD;
        System.out.println(answer);
    }

    static long power(long a, long p) {
        long temp = 1L;
        while (p > 0) {
            if (p % 2 == 1)
                temp = (temp * a) % MOD;
            p /= 2;
            a = a * a % MOD;
        }
        return temp;
    }
}
