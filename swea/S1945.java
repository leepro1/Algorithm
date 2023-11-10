package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] exponent = { 2, 3, 5, 7, 11 };
		int[] cnt;
		int n;

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			cnt = new int[5];

			for (int i = 0; i < 5; i++) {
				while (n % exponent[i] == 0) {
					n /= exponent[i];
					cnt[i]++;
				}
			}

			sb.append("#" + t);
			for (int value : cnt) {
				sb.append(" " + value);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
