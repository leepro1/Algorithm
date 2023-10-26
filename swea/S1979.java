package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int n, k, cnt;
		int[][] map;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			// 비어있으면 1이 입력된다.
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;
			// 가로줄 검사
			int tempCnt;
			for (int i = 0; i < n; i++) {
				tempCnt = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1)
						tempCnt++;
					if (map[i][j] == 0 || j == n - 1) {
						if (tempCnt == k)
							cnt++;
						tempCnt = 0;
					}
				}
			}

			// 세로줄 검사
			for (int i = 0; i < n; i++) {
				tempCnt = 0;
				for (int j = 0; j < n; j++) {
					if (map[j][i] == 1)
						tempCnt++;
					if (map[j][i] == 0 || j == n - 1) {
						if (tempCnt == k)
							cnt++;
						tempCnt = 0;
					}
				}
			}

			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
