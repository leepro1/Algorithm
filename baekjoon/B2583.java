//https://www.acmicpc.net/problem/2583
/*
 * 영역 구하기 - 그래프
 * 직사각형을 제외한 곳에 BFS를 하여 직사각형의 개수(넓이)를 구한다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dx = { -1, 1, 0, 0 }; // 상하좌우 검사를 위한 배열
		int[] dy = { 0, 0, -1, 1 }; // 상하좌우 검사를 위한 배열

		boolean[][] visited = new boolean[M][N];
		int[][] map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>(); // bfs로 풀기 위한 queue

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (map[nextX][nextY] == 0) {
					map[nextX][nextY] = map[temp[0]][temp[1]] + 1;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}

	}
}
