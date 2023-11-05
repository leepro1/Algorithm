package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5215 {
	static int n, max, l;
	static int[][] foodInfo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			max = 0;

			foodInfo = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				foodInfo[i][0] = Integer.parseInt(st.nextToken());
				foodInfo[i][1] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, 0);

			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	// nowT는 현재 맛 점수, nowL은 현재 열량
	public static void dfs(int start, int nowT, int nowL) {
		max = Math.max(max, nowT);

		for (int i = start; i < n; i++) {
			if (nowL + foodInfo[i][1] <= l)
				dfs(i + 1, nowT + foodInfo[i][0], nowL + foodInfo[i][1]);
		}

		return;
	}
}
