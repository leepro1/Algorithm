package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int m1, d1, m2, d2, answer;
		int[] monthDate = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 0월을 비워둠

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());

			answer = 1;

			if (m1 == m2) {
				answer = d2 - d1 + 1;
			} else {
				answer += monthDate[m1] - d1;
				for (int i = m1 + 1; i < m2; i++) {
					answer += monthDate[i];
				}
				answer += d2;
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
