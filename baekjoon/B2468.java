//https://www.acmicpc.net/problem/2468
/*
 * 안전 영역 - 그래프 탐색
 * 그래프를 탐색하며 안전지대의 수를 구하는 문제이다. 최대높이를 구해 1부터 ++해서 구해보자
 * 먼저 풀었던 문제들처험 BFS로 할 수 있지만 이번엔 DFS로 풀어보자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2468 {
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		int maxHeight = 0; // 최대높이
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (maxHeight < map[i][j]) {
					maxHeight = map[i][j];
				}
			}
		}

		int maxCnt = 1; // 최대 영역의 수

		for (int h = 1; h < maxHeight; h++) { // h는 높이이다
			visited = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			if (maxCnt < cnt) {
				maxCnt = cnt;
			}
		}
		System.out.println(maxCnt);
	}

	private static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;

			if (!visited[nextX][nextY] && map[nextX][nextY] > h) {
				dfs(nextX, nextY, h);
			}
		}
	}

}
