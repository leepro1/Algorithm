package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1974 {
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) {
			map = new int[9][9];

			// 스도쿠 초기화
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + test_case + " " + checkMap() + "\n");
		}
		System.out.println(sb);
	}

	public static int checkMap() {
		// 가로 줄 검사
		for (int i = 0; i < 9; i++) {
			check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (check[map[i][j]])
					return 0;
				check[map[i][j]] = true;
			}
		}

		// 세로 줄 검사
		for (int i = 0; i < 9; i++) {
			check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (check[map[j][i]])
					return 0;
				check[map[j][i]] = true;
			}
		}

		// 3x3 줄 검사
		for (int l = 0; l < 9; l += 3) {
			for (int k = 0; k < 9; k += 3) {
				check = new boolean[10];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (check[map[k + i][l + j]])
							return 0;
						check[map[k + i][l + j]] = true;
					}
				}
			}
		}
		
		return 1;
	}
}
