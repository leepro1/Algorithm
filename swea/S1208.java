package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, min, max;
		int[] height;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			n = Integer.parseInt(br.readLine());
			height = new int[101];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 100; i++) {
				int inputHeight = Integer.parseInt(st.nextToken());
				height[inputHeight]++;
				min = Math.min(min, inputHeight);
				max = Math.max(max, inputHeight);
			}

			while (true) {

				if (n == 1 && max - min == 1)
					break;
				
				if (n == 0 || min == max)
					break;

				height[max]--;
				height[min]--;
				height[max - 1]++;
				height[min + 1]++;
				n--;

				// 높이 min의 평탄화 작업 완료시
				if (height[min] == 0) {
					min++;
				}

				// 높이 max의 평탄화 작업 완료시
				if (height[max] == 0) {
					max--;
				}
			}
			sb.append("#" + test_case + " " + (max - min) + "\n");
		}
		System.out.println(sb);
	}
}
