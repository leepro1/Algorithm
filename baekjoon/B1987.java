//https://www.acmicpc.net/problem/1987
/*
 * 알파벳 - 백트래킹, 그래프
 * dfs로 재귀를 통해 말이 최대 움직인 횟수를 구하자
 * 앞에 나온 알파벳을 배열에 저장하여 방문여부를 따지며 백트래킹
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {
	private static int R, C;
	private static char[][] board;
	private static boolean[][] visited; // 방문여부를 저장할 배열
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static boolean[] checkAlphabet = new boolean[26]; // index = 알파벳(대문자) - 65
	private static int max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		visited[r][c] = true;
		checkAlphabet[board[r][c] - 65] = true;
		max = Math.max(max, cnt);

		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];

			if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
				continue;

			if (!visited[nextR][nextC] && !checkAlphabet[board[nextR][nextC] - 65]) {

				dfs(nextR, nextC, cnt + 1);
				checkAlphabet[board[nextR][nextC] - 65] = false; // 뒤로 돌아오면 복구
				visited[nextR][nextC] = false; // 뒤로 돌아오면 복구
			}
		}
	}
}
