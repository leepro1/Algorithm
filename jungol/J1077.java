package jungol;

//수행시간: 164ms       메모리: 32.5Mb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1077 {
	static class Thing {
		int w, p;

		public Thing(int w, int p) {
			this.w = w;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		Thing[] things = new Thing[N];
		int[] dp = new int[W + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= W; i++) {
			dp[i] = dp[i - 1];
			for (int j = 0; j < N; j++) {
				if (i >= things[j].w)
					dp[i] = Math.max(dp[i], dp[i - things[j].w] + things[j].p);
			}
		}

		System.out.println(dp[W]);

	}
}
