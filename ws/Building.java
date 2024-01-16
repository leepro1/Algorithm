package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Building {

	static int n, answer;
	static char[][] map;
	static boolean[][] cantBuilding;
	static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			answer = 0;
			map = new char[n][n];
			cantBuilding = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken().charAt(0);

					if (map[i][j] == 'G') {
						checkCantBuilding(i, j);
					}
					
					// B이 하나라도 있을 때
					if (answer == 0 && map[i][j] == 'B')
						answer = 2;
				}
			}

			if (answer != 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (!cantBuilding[i][j])
							cntBuilding(i, j);
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void checkCantBuilding(int x, int y) {

		for (int i = 0; i <= 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;

			cantBuilding[nextX][nextY] = true;
		}
	}

	static void cntBuilding(int x, int y) {
		int tempCnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (map[i][y] == 'B')
				tempCnt++;
			if (map[x][i] == 'B')
				tempCnt++;
		}
		answer = Math.max(answer, tempCnt - 1);
	}
}

