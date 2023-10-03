/*
 * https://www.acmicpc.net/problem/11403
 * 경로 찾기
 * 모든 정점에서 다른 정점으로(자신 포함) 가는 경로 유무를 구한다.
 * i에서 j로 가는 경로가 i->k->j 가 존재하는지 check
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403 {
	static int[][] matrix;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		matrix = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		floyd();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][k] == 1 && matrix[k][j] == 1)
						matrix[i][j] = 1;
				}
			}
		}
	}
}
