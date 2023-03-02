//https://www.acmicpc.net/problem/2206
/*
 * 벽 부수고 이동하기 - BFS
 * (1,1)에서 출발하여 (N,M)으로 이동하는 문제, 시작하는 칸과 끝나는 칸, 부순 벽도 count한다.
 * 첫 시도 -> 목표지점까지 갈 때 한개의 벽은 탐색할 수 있도록 한다.
 * 			이 때 벽을 부순 경우 여부처리를 queue에 넣는 배열에 2번 index로 처리하겠다.
 * 			map배열에 바로 count를 하니 방문여부 체크가 모호해져서 queue에 넣은 배열에 3번 index처리하겠다. -> 메모리 초과로 실패
 * 
 * 두번째 시도 -> 메모리 초과가 큐에 넣는 배열때문인 것 같아 전부 int로 처리한 배열을 새로운 클래스로 정의해주자 -> 첫 시도와는 count와 벽을 부순여부 확인 index 자리를 바꾸었다.
 * 			  입력받는 map도 boolean형태로 바꾸어주고 visited배열로 방문여부처리도 해주자.
 * 
 * 세번째 시도 -> 메모리문제만 해결하면 맞을 줄 알았더니 틀렸다. 
 * 			  틀린점) 목적지까지 가는 여러 방법 중 벽을부셔서 먼저 간 뒤 visited를 체크할 경우 벽을 부수지 않고 온 경우와 겹치게 된다. 
 * 					예를 들어 1번 방법에서 갔던 길이면 visited 배열에 이미 체크되어있는데 이를 고려하지 않았다.
 * 					visited배열을 벽을 부셨는지에 여부에 따라 한번 더 나누어 주겠다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
	private static class Location {
		int x;
		int y;
		int cnt;
		boolean breakWall;

		public Location(int x, int y, int cnt, boolean breakWall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.breakWall = breakWall; // 부술 수 없다면 true
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '1') // 벽이면 false 아니면 true
					map[i][j] = false;
				else
					map[i][j] = true;
			}
		}

		if (N == 1 && M == 1) { // 시작과 끝이 같을 때
			System.out.println(1);
			return;
		}

		boolean[][][] visited = new boolean[N][M][2];

		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0, 0, 1, false));

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			Location temp = queue.poll();

			if (temp.x == N - 1 && temp.y == M - 1) { // 종료조건
				System.out.println(temp.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;

				if (map[nextX][nextY] == false && temp.breakWall == true) // 만약 벽을 만났는데 부술 수 없다면 pass
					continue;

				if (map[nextX][nextY] == false) { // 벽을 만났을 때
					if (temp.breakWall == false) {// 벽을 부술 기회가 있을 때 부순다.
						queue.offer(new Location(nextX, nextY, temp.cnt + 1, true));
						visited[nextX][nextY][1] = true;
					}
				}

				else if (map[nextX][nextY] == true) { // 벽이 아닐 때
					if (!visited[nextX][nextY][0] && temp.breakWall == false) {
						queue.offer(new Location(nextX, nextY, temp.cnt + 1, temp.breakWall));
						visited[nextX][nextY][0] = true;
					} else if (!visited[nextX][nextY][1] && temp.breakWall == true) {
						queue.offer(new Location(nextX, nextY, temp.cnt + 1, temp.breakWall));
						visited[nextX][nextY][1] = true;

					}
				}
			}
		}
		System.out.println(-1);
	}
}
