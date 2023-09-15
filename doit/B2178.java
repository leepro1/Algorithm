/*
 * https://www.acmicpc.net/problem/2178
 * 미로탐색
 * BFS를 활용하여 탐색을 한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] matrix = new boolean[N + 1][M + 1];
		int[][] visited = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				visited[i][j] = -1;
				if (str.charAt(j - 1) == '1')
					matrix[i][j] = true;
				else
					matrix[i][j] = false;
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, 1 });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 1 || nextY < 1 || nextX > N || nextY > M)
					continue;
				if (!matrix[nextX][nextY] || visited[nextX][nextY] != -1)
					continue;
				else {
					visited[nextX][nextY] = visited[temp[0]][temp[1]] + 1;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}

		System.out.println(visited[N][M] + 2);
	}
}
