package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6190 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, max;
		int[] arr;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (checkNum(arr[i] * arr[j])) {
						max = Math.max(max, arr[i] * arr[j]);
					}
				}
			}

			if (max == 0)
				max = -1;

			sb.append("#" + t + " " + max + "\n");
		}

		System.out.println(sb);
	}

	static boolean checkNum(int num) {
		while (num >= 10) {
			if (num % 10 < (num % 100) / 10) {
				return false;
			} else {
				num /= 10;
			}
		}

		return true;
	}
}
