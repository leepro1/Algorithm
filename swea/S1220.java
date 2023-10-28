package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int n, cnt, flag;
		int[][] arr;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;

			// flag == 0 :교착상태의 조건이 하나도 없을 때
			// flag == 1 :교착상태의 조건이 하나 있을 때
			// flag == 2 :교착상태의 조건이 전부 있을 때

			for (int j = 0; j < 100; j++) {
				flag = 0;
				for (int i = 0; i < 100; i++) {
					if (arr[i][j] == 0 && flag == 2) {
						flag = 0;
					}

					if (arr[i][j] == 1) {
						flag = 1;
					} else if (arr[i][j] == 2 && flag == 1) {
						cnt++;
						flag = 2;
					}
				}
			}

			sb.append("#" + test_case + " " + cnt + "\n");
		}

		System.out.println(sb);
	}
}
