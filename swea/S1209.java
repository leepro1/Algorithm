package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1209 {
	static int[][] arr, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max, n;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[101][101];
			sum = new int[101][101];

			for (int i = 1; i <= 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
				}
			}

			max = findMaxSum();

			sb.append("#" + n + " " + max + "\n");
		}
		System.out.println(sb);
	}

	public static int findMaxSum() {
		int max = 0;
		int rightDown = 0;
		int leftDown = 0;

		for (int i = 1; i <= 100; i++) {

			// 우하향 대각선 구하기
			rightDown += arr[i][i];

			// 좌하향 대각선 구하기
			leftDown += arr[i][101 - i];

			// 행 최대값 비교
			max = Math.max(max, sum[i][100] - sum[i - 1][100]);

			// 열 최대값 비교
			max = Math.max(max, sum[100][i] - sum[100][i - 1]);
		}

		max = Math.max(max, rightDown);
		max = Math.max(max, leftDown);

		return max;
	}
}
