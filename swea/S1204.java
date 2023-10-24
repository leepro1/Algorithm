package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] score = new int[101];
			int mode = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 1000; i++) {
				int tempScore = Integer.parseInt(st.nextToken());
				score[tempScore]++;

				if (score[tempScore] > score[mode])
					mode = tempScore;
				if (score[tempScore] == score[mode])
					mode = Math.max(tempScore, mode);
			}
			sb.append("#" + n + " " + mode + "\n");
		}
		System.out.println(sb);
	}
}
