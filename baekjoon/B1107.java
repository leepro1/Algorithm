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

		brokenNum = new boolean[10];

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (M-- > 0) {
				brokenNum[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int cnt = Math.abs(N - 100); // 최초에 100번을 보고 있으므로

		for (int i = 0; i <= 1000000; i++) {
			int tempLen = check(i);

			if (tempLen > 0) {
				int tempCnt = Math.abs(N - i);
				cnt = Math.min(cnt, tempCnt + tempLen);
			}
		}

		System.out.println(cnt);
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
			len++;
		}
		return len;
	}
}
