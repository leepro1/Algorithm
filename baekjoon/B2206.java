//https://www.acmicpc.net/problem/2206
/*
 * 벽 부수고 이동하기 - BFS
 * (1,1)에서 출발하여 (N,M)으로 이동하는 문제, 시작하는 칸과 끝나는 칸, 부순 벽도 count한다.
 * 첫 시도 -> 목표지점까지 갈 때 한개의 벽은 탐색할 수 있도록 한다.
 * 이 때 벽을 부순 경우 여부처리를 queue에 넣는 배열에 2번 index로 처리하겠다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '1') // 탐색을 하며 cnt를 하기 쉽게 하기위해 0과 1을 바꿔주었다. -> 벽이면 0 아니면 1
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}

		if (N == 1 && M == 1) { // 시작과 끝이 같을 때
			System.out.println(1);
			return;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0, 1 }); // 2번 index가 -1이면 벽을 부술 수 없다, 0이면 부술 수 있다. 3번 index는 count이다.

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			if (temp[0] == N - 1 && temp[1] == M - 1) { // 종료조건
				System.out.println(temp[3]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;

				if (map[nextX][nextY] == 0 && temp[2] == -1) // 만약 벽을 만났는데 부술 수 없다면 pass
					continue;

				if (map[nextX][nextY] == 0) { // 벽을 만났을 때
					if (temp[2] == 0) {// 벽을 부술 기회가 있을 때 부순다.
						queue.offer(new int[] { nextX, nextY, -1, temp[3] + 1 });
					}
				}

				else if (map[nextX][nextY] == 1 && nextX + nextY != 0) { // 벽이 아니고 출발지가 아닐 때
					queue.offer(new int[] { nextX, nextY, temp[2], temp[3] + 1 });
				}
			}
		}
		System.out.println(-1);
	}
}
