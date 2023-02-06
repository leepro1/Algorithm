//https://www.acmicpc.net/problem/2583
/*
 * 영역 구하기 - 그래프
 * 직사각형을 제외한 곳에 BFS를 하여 직사각형의 개수(넓이)를 구한다.
 * 좌표평면으로 보자면 1사분면에 해당하는 것처럼 좌표(위치)를 표시하니 이점을 유의하자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583 {
	private static boolean[][] map;
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 검사를 위한 배열
	private static int[] dy = { 0, 0, -1, 1 }; // 상하좌우 검사를 위한 배열
	private static Queue<int[]> queue = new LinkedList<int[]>(); // bfs로 풀기 위한 queue
	private static int M, N, K;
	private static int area = 1; // 넓이를 셀 변수
	private static int cnt = 0; // 영역의 개수를 셀 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = true; // 벽을 방문한 것으로 표시
				}
			}
		}

		ArrayList<Integer> cntArray = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					queue.offer(new int[] { i, j });
					map[i][j] = true;
					cntArray.add(bfs());
					area = 1;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(cntArray);

		for (Integer i : cntArray) {
			System.out.print(i + " ");
		}
	}

	private static int bfs() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
					continue;
				if (!map[nextX][nextY]) {
					map[nextX][nextY] = true;
					queue.offer(new int[] { nextX, nextY });
					area++;
				}
			}
		}
		return area;
	}
}
