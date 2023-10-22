package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1926 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int cnt;
		for (int i = 1; i <= n; i++) {

			// cnt작업
			cnt = 0;
			int temp = i;
			while (true) {
				switch (temp % 10) {
				case 3:
				case 6:
				case 9:
					cnt++;
				}
				if (temp < 10)
					break;
				else
					temp /= 10;
			}

			// 출력 전 작업
			if (cnt == 0)
				sb.append(i + " ");
			else {
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}