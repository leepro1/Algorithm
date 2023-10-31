package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, answer;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			if (n % 2 == 0) {
				answer = n / -2;
			} else {
				answer = (n + 1) / 2;
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
