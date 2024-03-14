package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1535 {
	static int N;
	static boolean[] visited;

	static int[] L;
	static int[] J;

	static int score = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		L = new int[N];
		J = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			L[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			J[i] = Integer.parseInt(st.nextToken());

		subset(0);

		System.out.println(score);
	}

	static void subset(int depth) {
		if (depth == N) {
			int tempScore = 0;
			int tempHp = 100;

			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					tempScore += J[i];
					tempHp -= L[i];
				}
			}

			if (tempHp <= 0)
				return;

			score = Math.max(score, tempScore);
			return;
		}

		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}
}

