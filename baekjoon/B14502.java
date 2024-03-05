package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {
	static int N, M;
	static int[][] map;
	static int cntZero, answer;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<int[]> virus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					cntZero++;

				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		combi(0, 0, 0);

		System.out.println(answer);
	}

	static void combi(int depth, int x, int y) {
		if (depth == 3) {
			answer = Math.max(answer, check());
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == x && j < y)
					continue;

				if (map[i][j] == 0) {
					map[i][j] = 1;
					combi(depth + 1, i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	static int check() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (int[] point : virus) {
			queue.add(point);
		}

		int tempCnt = 0;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;

				if (map[nextX][nextY] != 0 || visited[nextX][nextY])
					continue;

				visited[nextX][nextY] = true;
				queue.add(new int[] { nextX, nextY });
				tempCnt++;
			}
		}

		return cntZero - 3 - tempCnt;
	}
}
