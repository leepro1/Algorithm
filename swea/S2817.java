package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2817 {
	static int[] arr;
	static int n, k, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;

			dfs(0, 0);

			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int start, int sum) {
		if (start == n) {
			if (sum == k) {
				cnt++;	
			}
			return;
		}

		dfs(start + 1, sum);
		sum += arr[start];
		dfs(start + 1, sum);
	}
}
