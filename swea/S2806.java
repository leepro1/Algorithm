package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2806 {
	static int n, cnt;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			cnt = 0;
			map = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[0][i] = true;
				dfs(1);
				map[0][i] = false;
			}

			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (checkMap(depth, i)) {
				map[depth][i] = true;
				dfs(depth + 1);
				map[depth][i] = false;
			}
		}
	}

	static boolean checkMap(int x, int y) {
		// 행 체크
		for (int i = 0; i < n; i++) {
			if (y == i)
				continue;
			if (map[x][i])
				return false;
		}

		// 열 체크
		for (int i = 0; i < n; i++) {
			if (x == i)
				continue;
			if (map[i][y])
				return false;
		}

		int tempX;
		int tempY;

		// 우하향 대각선 체크
		tempX = x + 1;
		tempY = y + 1;
		while (tempX < n && tempY < n) {
			if (map[tempX][tempY])
				return false;
			tempX++;
			tempY++;
		}
		tempX = x - 1;
		tempY = y - 1;
		while (tempX >= 0 && tempY >= 0) {
			if (map[tempX][tempY])
				return false;
			tempX--;
			tempY--;
		}

		// 우상향 대각선 체크
		tempX = x - 1;
		tempY = y + 1;
		while (tempX >= 0 && tempY < n) {
			if (map[tempX][tempY])
				return false;
			tempX--;
			tempY++;
		}
		tempX = x + 1;
		tempY = y - 1;
		while (tempX < n && tempY >= 0) {
			if (map[tempX][tempY])
				return false;
			tempX++;
			tempY--;
		}

		return true;
	}
}
