package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5215_2 {
	static class FoodInfo {
		int taste, cal;

		FoodInfo(int taste, int cal) {
			this.taste = taste;
			this.cal = cal;
		}
	}

	static int n, l, answer;
	static FoodInfo[] foodArr;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			foodArr = new FoodInfo[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				foodArr[i] = new FoodInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			answer = 0;
			for (int i = 0; i < n; i++) {
				dfs(i, foodArr[i].taste, foodArr[i].cal);
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int nowIndex, int totalTaste, int totalCal) {
		if (nowIndex == n - 1) {
			answer = Math.max(totalTaste, answer);
		}

		for (int i = nowIndex + 1; i < n; i++) {
			if (totalCal + foodArr[i].cal <= l) {
				dfs(i, totalTaste + foodArr[i].taste, totalCal + foodArr[i].cal);
			} else {
				answer = Math.max(totalTaste, answer);
			}
		}
	}
}
