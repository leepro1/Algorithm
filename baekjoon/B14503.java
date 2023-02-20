//https://www.acmicpc.net/problem/14503
/*
 * 로봇 청소기 - 시뮬레이션
 * 방향 0-북, 1-동, 2-남, 3-서 이므로 반시계방향으로 도는 것을 %4로 연산해서 처리하자
 * 좌표가 수학에서 흔히 배운 x, y가아닌 행렬에서의 row, col인것을 주의하자.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] matrix = new boolean[n][m]; // 벽일 때(false)
		boolean[][] visited = new boolean[n][m];

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if (st.nextToken().equals("1")) { // 입력값이 벽일 때
					matrix[i][j] = true;
				} else {
					matrix[i][j] = false;
				}
			}
		}

		// 0-북, 1-동, 2-남, 3-서
		int[] dcol = { 0, 1, 0, -1 };
		int[] drow = { -1, 0, 1, 0 };

		int cnt = 0;

		while (true) {
			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if (matrix[row][col] == false && visited[row][col] == false) {
				visited[row][col] = true;
				cnt++;
			}

			boolean check = false; // 청소할 곳이 생기면 true로 바뀜
			for (int i = 0; i < 4; i++) {
				direction = (direction + 3) % 4; // 반시계방향으로 회전하므로 +3을 하였다.
				int nextRow = row + drow[direction];
				int nextCol = col + dcol[direction];

				if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m)
					continue;

				if (!matrix[nextRow][nextCol] && !visited[nextRow][nextCol]) {
					row = nextRow;
					col = nextCol;
					check = true;
					break;
				}

			}

			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if (check == false) {
				row += drow[(direction + 2) % 4];
				col += dcol[(direction + 2) % 4];

				// 후진을 할 수 없다면
				if (row < 0 || col < 0 || row >= n || col >= m || matrix[row][col])
					break;

			}
			check = false;
		}

		System.out.println(cnt);
	}
}
