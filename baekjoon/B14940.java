package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {
	static int N, M;
	static int[][] map;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				switch (Integer.parseInt(st.nextToken())) {
				case 0:
					map[i][j] = 0;
					break;
				case 1:
					map[i][j] = -1;
					break;
				case 2:
					map[i][j] = 0;
					queue.add(new int[] { i, j });
					break;
				}
			}
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;

				if (map[nextX][nextY] == -1) {
					map[nextX][nextY] = map[now[0]][now[1]] + 1;
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
	}
}
