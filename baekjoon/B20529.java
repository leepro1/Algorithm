package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20529 {
	static int N, answer;
	static String[] data;
	static int[] pick = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			data = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = st.nextToken();
			}

			answer = Integer.MAX_VALUE;

			if (N > 32)
				answer = 0;
			else
				combi(0, 0);

			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	static void combi(int depth, int start) {
		if (depth == 3) {
			int sum = 0;
			sum += calDist(0, 1);
			sum += calDist(1, 2);
			sum += calDist(0, 2);

			answer = Math.min(answer, sum);
			return;
		}

		for (int i = start; i < N; i++) {
			pick[depth] = i;
			combi(depth + 1, i + 1);
		}
	}

	static int calDist(int x, int y) {
		int temp = 0;

		for (int i = 0; i < 4; i++) {
			if (data[pick[x]].charAt(i) != data[pick[y]].charAt(i))
				temp++;
		}

		return temp;
	}
}
