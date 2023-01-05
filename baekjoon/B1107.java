//https://www.acmicpc.net/problem/1107
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107 {
	private static boolean[] brokenNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine()); // 고장난 숫자버튼 수
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			brokenNum[Integer.parseInt(st.nextToken())] = true;
		}

		int cnt = Math.abs(N - 100);

		if (100 != N)
			cnt = +check(N);
	}

	private static int check(int n) {
		if (n == 0) {
			if (brokenNum[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (n > 0) {
			if (brokenNum[n % 10]) {
				return 0;
			}
			n /= 10;
			len += 1;
		}
		return len;
	}
}
