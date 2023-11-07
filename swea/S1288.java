package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1288 {
	static int n, answer, restCnt;
	static boolean[] checkNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			checkNum = new boolean[10];

			restCnt = 10;
			for (int i = 1; restCnt > 0; i++) {
				cntNum(n * i);
				answer = n * i;
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void cntNum(int num) {
		while (true) {
			if (!checkNum[num % 10]) {
				checkNum[num % 10] = true;
				restCnt--;
			}
			if (num < 10)
				break;
			num /= 10;
		}
	}
}
