package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppleTree {
	static int n;
	static int[][] map;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		String str;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer = Math.max(answer, sumNutrients(i, j));
			}
		}

		System.out.println(answer);
	}

	static int sumNutrients(int x, int y) {
		int tempSum = map[x][y];

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;

			tempSum += map[nextX][nextY];
		}

		return tempSum;
	}
}
