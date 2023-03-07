//https://www.acmicpc.net/problem/11054
/*
 * 가장 긴 바이토닉 부분 수열 - LIS_dp
 * 최장 증가 부분 수열 알고리즘을 이용하여 풀어보자. 
 * 감소하는 부분 수열도 구해야 하니 LIS알고리즘을 역으로 풀고 증가와 감소 부분 수열을 합하여 최장 길이를 구하자
 * 첫 시도) top-down방식으로 재귀를 통해 풀어보니 시간 초과가 났다.
 * 두번째 시도) bottom-up방식으로 바꾸어 반복문으로 풀어보자.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054 {
	static int[] upDp, downDp, seq;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		upDp = new int[n];
		downDp = new int[n];
		seq = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		LIS();
		LDS();

		int max = upDp[0] + downDp[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, upDp[i] + downDp[i]);
		}

		System.out.println(max - 1);
	}

	private static void LIS() {

		for (int i = 0; i < n; i++) {
			if (upDp[i] == 0)
				upDp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j])
					upDp[i] = Math.max(upDp[i], upDp[j] + 1);
			}

		}
	}

	private static void LDS() {

		for (int i = n - 1; i >= 0; i--) {
			if (downDp[i] == 0)
				downDp[i] = 1;

			for (int j = n - 1; j > i; j--) {
				if (seq[i] > seq[j])
					downDp[i] = Math.max(downDp[i], downDp[j] + 1);
			}

		}
	}
}
