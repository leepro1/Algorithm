package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1961 {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] matrix, matrix90, matrix180, matrix270;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			matrix = new int[n][n];
			matrix90 = new int[n][n];
			matrix180 = new int[n][n];
			matrix270 = new int[n][n];

			// 매트릭스 초기화
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			matrix90 = lotation(matrix);
			matrix180 = lotation(matrix90);
			matrix270 = lotation(matrix180);
			
			//부분 출력부
			StringBuilder sbTemp = new StringBuilder();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sbTemp.append(matrix90[i][j]);
				}
				sbTemp.append(" ");
				for (int j = 0; j < n; j++) {
					sbTemp.append(matrix180[i][j]);
				}
				sbTemp.append(" ");
				for (int j = 0; j < n; j++) {
					sbTemp.append(matrix270[i][j]);
				}
				sbTemp.append(" \n");
			}
			
			sb.append("#" + t + "\n" + sbTemp);
		}
		System.out.println(sb);
	}

	public static int[][] lotation(int[][] arr) {
		int[][] tempMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tempMatrix[j][n - i - 1] = arr[i][j];
			}
		}

		return tempMatrix;
	}
}
