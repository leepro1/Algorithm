package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1983 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, k;
		int targetScore = 0;
		Integer[] score;
		String[] credit = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			score = new Integer[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int midScore = Integer.parseInt(st.nextToken());
				int finalScore = Integer.parseInt(st.nextToken());
				int assignment = Integer.parseInt(st.nextToken());

				score[i] = midScore * 35 + finalScore * 45 + assignment * 20;
				if (i == k - 1)
					targetScore = score[i];
			}

			Arrays.sort(score, Collections.reverseOrder());

			// 각 학점의 커트라인과 비교한다.
			int cnt = 0;
			for (int i = n / 10 - 1; i < n; i += n / 10) {
				if (score[i] <= targetScore) {
					sb.append("#" + t + " " + credit[cnt] + "\n");
					break;
				}
				cnt++;
			}
		}
		System.out.println(sb);
	}
}
