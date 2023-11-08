package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1976 {
	static int answerH, answerM;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int h1, m1, h2, m2;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			h1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			h2 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());

			calTime(h1, h2, m1, m2);

			if (answerH == 0)
				answerH = 12;

			sb.append("#" + t + " " + answerH + " " + answerM + "\n");
		}
		System.out.println(sb);
	}

	static void calTime(int h1, int h2, int m1, int m2) {
		answerM = m1 + m2;
		answerH = h1 + h2 + answerM / 60;

		answerH %= 12;
		answerM %= 60;
	}
}
