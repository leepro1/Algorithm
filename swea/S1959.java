package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1959 {
	static int n, m, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] arrA; // 크기가 더 큰 배열
		int[] arrB; // 크기가 더 작은 배열

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arrA = new int[n];
			arrB = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;

			if (n > m) {
				findMax(arrA, arrB);
			} else {
				findMax(arrB, arrA);
			}

			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

	public static void findMax(int[] arrBig, int[] arrSmall) {
		for (int i = 0; i <= arrBig.length - arrSmall.length; i++) {
			int sum = 0;

			for (int j = 0; j < arrSmall.length; j++) {
				sum += arrBig[i + j] * arrSmall[j];
			}
			max = Math.max(max, sum);
		}
	}
}
