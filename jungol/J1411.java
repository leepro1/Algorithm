package jungol;

//수행시간:103ms       메모리:31.8MB
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1411 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 20100529;
		}

		System.out.println(dp[N]);
	}
}
