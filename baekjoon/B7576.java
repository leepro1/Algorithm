//https://www.acmicpc.net/problem/7576
/*
 토마토문제 - BFS 
 Queue를 사용하여 BFS로 푼다. 이 때 상하좌우를 검사한다. 토마토가 있는 모든 정점을 돌아가면서 탐색한다.
 토마토가 있는 모든 정점을 돌아가면서 하는 것 구현 -> 처음에 Queue에 넣어 풀어보자.
 거리가 늘어날 때마다 ++를 해주며 계산하자.
*/

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] visited = new int[N][M];

		Queue<int[]> queue = new LinkedList<int[]>(); // bfs로 풀기 위한 queue

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				visited[i][j] = Integer.parseInt(st.nextToken());
				if (visited[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 }; // 상하좌우 검사를 위한 배열
		int[] dy = { 0, 0, -1, 1 }; // 상하좌우 검사를 위한 배열

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (visited[nextX][nextY] == 0) {
					visited[nextX][nextY] = visited[temp[0]][temp[1]] + 1;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}

		int cnt = 0;

		Loop: 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) { // 안익은 토마토가 있으면 0으로 break
					cnt = 0;
					break Loop;
				}
				if (visited[i][j] > cnt) {
					cnt = visited[i][j];
				}
			}
		}

		System.out.println(cnt - 1); // 전부 익은상태는 1->0 으로, 나머지(안익은 토마토가 있는 상태 포함)는 -1씩을 해주어야함
	}
}
