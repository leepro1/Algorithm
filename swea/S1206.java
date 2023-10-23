package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1206 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] height = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;

			for (int i = 2; i < n - 2; i++) {
				int max = 0;
				for (int j = -2; j <= 2; j++) {
					if (j == 0)
						continue;

					if (height[i + j] >= height[i]) {
						max = 255;
						break;
					}
					max = Math.max(height[i + j], max);
				}
				if (max < height[i]) {
					cnt += height[i] - max;
				}
			}
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
