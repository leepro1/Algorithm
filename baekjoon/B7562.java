//https://www.acmicpc.net/problem/7562
/*
 * 나이트의 이동 - 그래프(BFS)
 * 나이트의 이동가능 위치를 잘 저장해놓는다. 
 * 다음위치의 cnt된 숫자가 이동전 위치의 +1 보다 크다면 탐색을 할 수 있게 해준다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[][] board;
	static int x1, y1, x2, y2;
	static int I;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			I = Integer.parseInt(br.readLine());
			board = new int[I][I];

			st = new StringTokenizer(br.readLine()); // 시작위치
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 종료위치
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			board[x1][y1] = 1;
			bfs(x1, y1);
		}
		System.out.println(sb);
	}

	static void bfs(int x1, int y1) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x1, y1 });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			if (temp[0] == x2 && temp[1] == y2) { // 종료위치에 도달할 때
				sb.append(board[temp[0]][temp[1]] - 1).append("\n");
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= I || nextY >= I)
					continue;
				if (board[nextX][nextY] == 0 || board[nextX][nextY] < board[temp[0]][temp[1]] + 1) {
					board[nextX][nextY] = board[temp[0]][temp[1]] + 1;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}
	}
}
