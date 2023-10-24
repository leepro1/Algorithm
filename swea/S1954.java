package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1954 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 오, 하, 왼, 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + "\n");

			int n = Integer.parseInt(br.readLine());

			int[][] snail = new int[n][n];
			boolean[][] visited = new boolean[n][n];

			int x = 0;
			int y = 0;
			int pattern = 0;
			int cnt = 1;

			while (true) {
				snail[x][y] = cnt++;
				visited[x][y] = true;
				
				if (cnt > n * n)
					break;
				
				int nextX = x + dx[pattern];
				int nextY = y + dy[pattern];

				if (nextX > n - 1 || nextY > n - 1 || nextX < 0 || nextY < 0 || visited[nextX][nextY]) {
					pattern = (pattern + 1) % 4;
				}
				
				x = x + dx[pattern];
				y = y + dy[pattern];
			}
			
			//출력부
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
