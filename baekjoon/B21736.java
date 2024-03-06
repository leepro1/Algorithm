package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21736 {
	static int N, M, cnt;
	static char[][] map;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (str.charAt(j)) {
				case 'I':
					queue.add(new int[] { i, j });
					map[i][j] = 'X';
					break;
				default:
					map[i][j] = str.charAt(j);
				}
			}
		}

		bfs();

		if (cnt == 0)
			System.out.println("TT");
		else
			System.out.println(cnt);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || map[nextX][nextY] == 'X')
					continue;

				if (map[nextX][nextY] == 'P')
					cnt++;

				map[nextX][nextY] = 'X';
				queue.add(new int[] { nextX, nextY });
			}
		}
	}
}
