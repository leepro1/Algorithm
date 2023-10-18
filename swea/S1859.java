package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1859 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int max = 0;
			long profit = 0;
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if (max < arr[j])
					max = arr[j];
			}

			for (int j = 0; j < n; j++) {
				if (arr[j] < max)
					profit = profit + (max - arr[j]);
				else if (arr[j] == max && j + 1 < n) {
					max = 0;
					for (int k = j + 1; k < n; k++) {
						if (max < arr[k])
							max = arr[k];
					}
				}
			}

			System.out.println("#" + i + " " + profit);
		}
	}
}