package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1970 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int money;
		int[] change;
		int[] changeLevel = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			money = Integer.parseInt(br.readLine());
			change = new int[8];

			for (int i = 0; i < 8; i++) {
				change[i] = money / changeLevel[i];
				money %= changeLevel[i];
			}

			sb.append("#" + test_case + "\n");

			for (int value : change) {
				sb.append(value+" ");
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
