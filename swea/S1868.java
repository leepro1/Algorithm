package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1868 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int count;

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];

			// 입력부 -1 == 지뢰
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					if (str.charAt(j) == '*') {
						map[i][j] = -1;
						visited[i][j] = true;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != -1) {
						countMines(i, j);
					}
				}
			}

			count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0 && !visited[i][j]) {
						count++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						count++;
					}
				}
			}

			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}

	// 주변 지뢰 세기
	static void countMines(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;

			if (map[nextX][nextY] == -1) {
				map[x][y]++;
			}
		}
	}

	static void dfs(int x, int y) {

		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;

			if (visited[nextX][nextY])
				continue;

			visited[nextX][nextY] = true;

			if (map[nextX][nextY] == 0) {
				dfs(nextX, nextY);
			}
		}
	}
}
