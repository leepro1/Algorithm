package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971 {
	static int N, answer = Integer.MAX_VALUE;
	static int[][] dist;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		order = new int[N + 1];
		tsp(0, 0);

		System.out.println(answer);
	}

	static void tsp(int depth, int flag) {
		if (depth == N) {
			int sum = 0;
			order[N] = order[0];
			for (int i = 1; i <= N; i++) {
				if (dist[order[i - 1]][order[i]] == 0)
					return;
				sum += dist[order[i - 1]][order[i]];
			}

			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				order[depth] = i;
				tsp(depth + 1, flag | 1 << i);
			}
		}

	}
}
